// ============================================================
// 1. ТОХИРГОО
// ============================================================
const POKEMON_API_V2 = `https://pokeapi.co/api/v2/pokemon`;
const TYPE_API_V2 = `https://pokeapi.co/api/v2/type`;
const FETCH_BATCH_SIZE = 100;   // API-с нэг удаад хэдийг татахыг заана
const REVEAL_BATCH_SIZE = 20;   // Дэлгэц дээр нэг удаад хэдийг харуулахыг заана

// ============================================================
// 2. ГЛОБАЛ ХУВЬСАГЧУУД (state)
// ============================================================
let pokemonIndex = [];      // Бүх 1025 pokemon-ы {name, url} жагсаалт
let filteredIndex = [];     // Хайлт/шүүлт/эрэмбэ хийсний дараах жагсаалт
let pokemonList = [];       // API-с бүрэн мэдээллийг нь татаж авсан pokemon-ууд
let visiblePokemon = [];    // Дэлгэц дээр харуулах бэлэн жагсаалт
let currentIndex = 0;       // filteredIndex дотор хэдэн хүртэл татсаныг заана
let revealedCount = 0;      // Дэлгэц дээр одоо хэдийг нь харуулж байгааг заана
let renderedCount = 0;      // DOM дотор одоо хэдэн карт үүссэнийг заана
let isLoading = false;      // Одоо fetch хийж байгаа эсэх
let hasMore = true;         // Цааш татах өгөгдөл байгаа эсэх

// ---------------- ХАЙЛТЫН ХУВЬСАГЧ ----------------
let searchQuery = "";
let searchType = "name";

// ---------------- ШҮҮЛТИЙН ХУВЬСАГЧ ----------------
let selectedTypes = [];
let heightFilter = { min: null, max: null };
let weightFilter = { min: null, max: null };

// Filter modal-д ашиглагдах өндөр/жингийн (см / кг) хязгаарууд
const HEIGHT_BUCKETS = {
    small: { min: null, max: 100 },
    medium: { min: 100, max: 200 },
    large: { min: 200, max: null }
};
const WEIGHT_BUCKETS = {
    small: { min: null, max: 10 },
    medium: { min: 10, max: 100 },
    large: { min: 100, max: null }
};

// ---------------- ЭРЭМБИЙН ХУВЬСАГЧ ----------------
let currentSort = "number-asc";


// ============================================================
// 3. DOM ЭЛЕМЕНТҮҮД
// ============================================================
const searchInput = document.querySelector(".search-input input");
const searchBtn = document.querySelector(".search-box .second-btn");

const POKEMON_CONTAINER = document.querySelector('#pokemon-grid');
const modal = document.getElementById('pokemon-modal');
const modalContent = document.getElementById('modal-content');
const closeModalBtn = document.getElementById('close-modal');

const sortDropdown = document.querySelector(".sort-dropdown");
const downDropdown = document.querySelector(".arrow-down");
const upDropdown = document.querySelector(".arrow-up");
const sortBtn = document.querySelector(".sort-btn");
const sortMenu = document.querySelector(".sort-menu");
const selectedSort = document.getElementById("selected-sort");
const sortItems = document.querySelectorAll(".sort-menu li");

const filterBtn = document.querySelector("#filter-btn");
const filterModal = document.querySelector(".filter-modal");

const searchBox = document.querySelector(".search-box");

// ============================================================
// 4. API - POKEMON-ы НЭРС/URL-ИЙН ЖАГСААЛТЫГ ТАТАХ
// ============================================================
// Эхлээд зөвхөн нэр + url-ыг нь татаж авна (хөнгөн), дараа нь
// хэрэгтэй pokemon-уудынх нь дэлгэрэнгүй мэдээллийг батчаар татна.
async function loadPokemonIndex() {
    try {
        const response = await fetch(`${POKEMON_API_V2}?limit=1025&offset=0`);
        if (!response.ok) {
            throw new Error("Failed to load Pokemon Index");
        }

        const data = await response.json();

        pokemonIndex = data.results.filter(item => {
            const id = getPokemonId(item.url);
            return id <= 1025;
        });

        filteredIndex = [...pokemonIndex];

    } catch (error) {
        console.error("Index loading error:", error);
    }
}

// ============================================================
// 5. URL-АС ID-Г НЬ АВАХ
// ============================================================
function getPokemonId(url) {
    const parts = url.split("/");
    return Number(parts[parts.length - 2]);
}

// ============================================================
// 5b. TYPE-ЭЭР ХАЙХ (PokeAPI-ийн /type/{name} ашиглана)
// ============================================================
// Тухайн нэг type-д хамаарах pokemon-уудын {name, url} жагсаалтыг татаж авна.
async function fetchTypeIndex(typeName) {
    const response = await fetch(`${TYPE_API_V2}/${typeName}`);
    if (!response.ok) {
        throw new Error(`Failed to load type ${typeName}`);
    }

    const data = await response.json();

    return data.pokemon
        .map(item => ({
            name: item.pokemon.name,
            url: item.pokemon.url
        }))
        .filter(item => getPokemonId(item.url) <= 1025);
}

// Сонгосон бүх type-үүдийн жагсаалтуудыг нэг рүү нэгтгэж, давхардлыг
// (нэр давхцаж байгаа pokemon) арилгаад буцаана.
async function buildTypeFilteredIndex(types) {
    let merged = [];

    for (const type of types) {
        const list = await fetchTypeIndex(type);

        for (const item of list) {
            const alreadyAdded = merged.some(p => p.name === item.name);
            if (!alreadyAdded) {
                merged.push(item);
            }
        }
    }

    return merged;
}

// ============================================================
// 6. API - ДЭЛГЭРЭНГҮЙ МЭДЭЭЛЛИЙГ БАТЧААР ТАТАХ (100-аар)
// ============================================================
async function fetchDetailsBatch(size) {
    if (!hasMore) {
        return;
    }

    if (!filteredIndex || filteredIndex.length === 0) {
        hasMore = false;
        return;
    }

    const batch = filteredIndex.slice(currentIndex, currentIndex + size);
    if (batch.length === 0) {
        hasMore = false;
        return;
    }

    const detailPromises = batch.map(async item => {
        const response = await fetch(item.url);
        if (!response.ok) {
            throw new Error(`Failed to load ${item.name}`);
        }
        return response.json();
    });

    const pokemonDetails = await Promise.all(detailPromises);
    pokemonList.push(...pokemonDetails);
    currentIndex += batch.length;

    if (currentIndex >= filteredIndex.length) {
        hasMore = false;
    }

    applyAll();
}

// ============================================================
// 6b. ДЭЛГЭЦ ДЭЭР 20-ИЙГААР НЭМЖ ХАРУУЛАХ (scroll бүрд дуудагдана)
// ============================================================
async function loadMore(revealCount = REVEAL_BATCH_SIZE) {
    if (isLoading) {
        return;
    }

    if (!hasMore && revealedCount >= visiblePokemon.length) {
        return;
    }

    isLoading = true;
    showSkeletons();

    try {
        // Дэлгэц дээр нэмж харуулах хангалттай pokemon бэлэн байхгүй бол
        // API-с дахин 100-аар татна.
        while (hasMore && visiblePokemon.length < revealedCount + revealCount) {
            await fetchDetailsBatch(FETCH_BATCH_SIZE);
        }

        revealedCount = Math.min(revealedCount + revealCount, visiblePokemon.length);

        renderPokemon();
        updateLoaderVisibility();

    } catch (error) {
        console.error("Batch loading error:", error);
    } finally {
        isLoading = false;
    }
}

// ============================================================
// 7. ХАЙЛТ
// ============================================================
function setSearch(query, type, clearTypeFilter = false) {
    searchQuery = query.trim().toLowerCase();
    searchType = type;

    if (clearTypeFilter) {
        selectedTypes = [];
        heightFilter = { min: null, max: null };
        weightFilter = { min: null, max: null };
    }

    isLoading = false;
    hasMore = true;

    rebuildFilteredIndex().then(() => {
        resetLoading();

        if (filteredIndex.length === 0) {
            visiblePokemon = [];
            revealedCount = 0;
            renderPokemon();
            updateLoaderVisibility();
            return;
        }

        loadMore(REVEAL_BATCH_SIZE);
    });
}

// ---------------- ХАЙЛТ ТААРЧ БАЙГАА ЭСЭХИЙГ ШАЛГАХ ----------------
function matchesSearchIndex(pokemon) {
    if (!searchQuery) {
        return true;
    }

    const pokemonId = String(getPokemonId(pokemon.url));
    const pokemonName = pokemon.name.toLowerCase();

    if (searchType === "id") {
        return pokemonId === searchQuery;
    }

    return pokemonName.includes(searchQuery);
}

const VALID_TYPES = [
    "normal", "fire", "water", "grass", "electric", "ice",
    "fighting", "poison", "ground", "flying", "psychic", "bug",
    "rock", "ghost", "dragon", "dark", "steel", "fairy"
];

// Хайлтын input-той холбоотой: тоо бол ID-аар, type нэр бол type-ээр,
// бусад бол нэрээр нь хайна.
function searchPokemon() {
    const query = searchInput.value.trim().toLowerCase();

    if (!query) {
        setSearch("", "name", true);
        return;
    }

    if (VALID_TYPES.includes(query)) {
        setFilter({ type: query });
        return;
    }

    if (!isNaN(query)) {
        setSearch(query, "id", true);
        return;
    }

    setSearch(query, "name", true);
}

async function rebuildFilteredIndex() {
    let result;

    // Type сонгосон бол PokeAPI-ийн /type/{name} эндпойнтоос шууд
    // харгалзах жагсаалтыг авна - 1025-ыг бүгдийг татах шаардлагагүй.
    if (selectedTypes.length > 0) {
        result = await buildTypeFilteredIndex(selectedTypes);
    } else {
        result = [...pokemonIndex];
    }

    result = result.filter(matchesSearchIndex);
    result = sortIndexList(result);
    filteredIndex = result;
}

// ============================================================
// 8. ШҮҮЛТҮҮР
// ============================================================
function setFilter(filterOptions) {
    // Шүүлтүүр өөрчлөгдөхөд хайлтын утгыг хамт цэвэрлэнэ
    searchInput.value = "";

    if (typeof filterOptions === "string") {
        selectedTypes = filterOptions ? [filterOptions] : [];
        heightFilter = { min: null, max: null };
        weightFilter = { min: null, max: null };
    } else {
        const {
            type = "",
            types = null,
            height = null,
            weight = null
        } = filterOptions || {};

        selectedTypes = types ? types : (type ? [type] : []);
        heightFilter = height ? HEIGHT_BUCKETS[height] : { min: null, max: null };
        weightFilter = weight ? WEIGHT_BUCKETS[weight] : { min: null, max: null };
    }

    searchQuery = "";
    rebuildFilteredIndex().then(() => {
        resetLoading();
        loadMore(REVEAL_BATCH_SIZE);
    });
}

// ---------------- ШҮҮЛТ ТААРЧ БАЙГАА ЭСЭХИЙГ ШАЛГАХ ----------------
function matchesFilter(pokemon) {
    // Өндөр/жин нь ЗӨВХӨН type сонгосон үед л хэрэгждэг.
    // Type сонгоогүй бол өндөр/жинг үл тооно.
    if (selectedTypes.length === 0) {
        return true;
    }

    const hasType = pokemon.types.some(
        item => selectedTypes.includes(item.type.name)
    );

    if (!hasType) {
        return false;
    }

    const height = pokemon.height * 10; // decimeter -> см
    if (heightFilter.min !== null && height < heightFilter.min) {
        return false;
    }
    if (heightFilter.max !== null && height >= heightFilter.max) {
        return false;
    }

    const weight = pokemon.weight / 10;
    if (weightFilter.min !== null && weight < weightFilter.min) {
        return false;
    }
    if (weightFilter.max !== null && weight >= weightFilter.max) {
        return false;
    }

    return true;
}

// ============================================================
// 9. ЭРЭМБЭЛЭХ
// ============================================================
function setSort(sortType) {
    currentSort = sortType;

    rebuildFilteredIndex().then(() => {
        resetLoading();
        loadMore(REVEAL_BATCH_SIZE);
    });
}

// {name, url} хэлбэртэй жагсаалтыг эрэмбэлнэ (ID/нэрээр)
function sortIndexList(list) {
    switch (currentSort) {
        case "number-asc":
            return list.sort((a, b) => getPokemonId(a.url) - getPokemonId(b.url));

        case "number-desc":
            return list.sort((a, b) => getPokemonId(b.url) - getPokemonId(a.url));

        case "name-asc":
            return list.sort((a, b) => a.name.localeCompare(b.name));

        case "name-desc":
            return list.sort((a, b) => b.name.localeCompare(a.name));

        default:
            return list;
    }
}

// Бүрэн мэдээлэлтэй pokemon объектуудын жагсаалтыг эрэмбэлнэ
function sortPokemonList(list) {
    switch (currentSort) {
        case "number-asc":
            return list.sort((a, b) => a.id - b.id);

        case "number-desc":
            return list.sort((a, b) => b.id - a.id);

        case "name-asc":
            return list.sort((a, b) => a.name.localeCompare(b.name));

        case "name-desc":
            return list.sort((a, b) => b.name.localeCompare(a.name));

        default:
            return list;
    }
}

// ============================================================
// 10. ТАТАЛТЫГ АНХНЫ ТӨЛӨВТ БУЦААХ
// ============================================================
function resetLoading() {
    currentIndex = 0;
    revealedCount = 0;
    renderedCount = 0;
    pokemonList = [];
    visiblePokemon = [];
    hasMore = true;
    isLoading = false;
    POKEMON_CONTAINER.innerHTML = "";
    updateLoaderVisibility();
}

// ---------------- LOADER ХАРАГДАХ ЭСЭХ ----------------
// Цааш татах өгөгдөл байгаа эсвэл татсан ч дэлгэц дээр гараагүй pokemon
// байвал spinner-ийг харуулна.
function updateLoaderVisibility() {
    const loader = document.querySelector("#loading-trigger");
    if (!loader) {
        return;
    }
    const canRevealMore = hasMore || revealedCount < visiblePokemon.length;
    loader.style.display = canRevealMore ? "flex" : "none";
}


// ============================================================
// 11. ХАЙЛТ + ШҮҮЛТ + ЭРЭМБИЙГ НЭГТГЭЖ ХАРУУЛАХАД БЭЛТГЭХ
// ============================================================
function applyAll() {
    // Хайлт болон type шүүлт filteredIndex түвшинд аль хэдийн хийгдсэн
    // тул энд давтан шалгахгүй. Зөвхөн өндөр/жингийн шүүлтийг л шалгана.
    let result = [...pokemonList];

    if (heightFilter.min !== null || heightFilter.max !== null ||
        weightFilter.min !== null || weightFilter.max !== null) {
        result = result.filter(matchesFilter);
    }

    result = sortPokemonList(result);
    visiblePokemon = result;

    return visiblePokemon;
}

// ============================================================
// 12. ДЭЛГЭЦ ДЭЭР ДҮРСЛЭХ (RENDER)
// ============================================================

// ---------------- ЗУРАГ АВАХ ----------------
function getArtwork(pokemon) {
    return pokemon.sprites.other['official-artwork'].front_default || pokemon.sprites.front_default;
}

// ---------------- TYPE ТЭМДЭГ ХАРУУЛАХ HTML ----------------
function getTypesDOM(pokemon) {
    return pokemon.types.map(item => `
    <div class="type ${item.type.name}">
        <img src="./images/tags/${item.type.name}.svg" alt="${item.type.name}">
        <p class="num">${item.type.name}</p>
    </div>
    `).join("");
}

// ---------------- SKELETON LOADER ----------------
// Өгөгдөл татагдаж дуустал харагдах хоосон, түр зуурын карт
function createSkeletonCard() {
    const el = document.createElement("div");
    el.className = "card skeleton";
    el.innerHTML = `
        <div class="pokemon-img"><div class="skel-img"></div></div>
        <div class="card-content">
            <div class="skel-line skel-title"></div>
            <div class="skel-line skel-num"></div>
        </div>
        <div class="types">
            <div class="skel-pill"></div>
            <div class="skel-pill"></div>
        </div>
    `;
    return el;
}

function showSkeletons(count = REVEAL_BATCH_SIZE) {
    for (let i = 0; i < count; i++) {
        POKEMON_CONTAINER.appendChild(createSkeletonCard());
    }
}

function clearSkeletons() {
    POKEMON_CONTAINER
        .querySelectorAll(".skeleton")
        .forEach(el => el.remove());
}

// ---------------- POKEMON КАРТУУДЫГ ЗУРАХ ----------------
function renderPokemon() {
    if (!POKEMON_CONTAINER) {
        return;
    }

    clearSkeletons();

    if (visiblePokemon.length === 0) {
        POKEMON_CONTAINER.innerHTML = `
            <div class="no-result">
                <img src="./images/loader.svg" alt="">
                <p>No pokémon matched your search!</p>
            </div>
        `;
        renderedCount = 0;
        return;
    }

    // Зөвхөн шинээр нэмэгдсэн картуудыг л зурна - бүгдийг дахин зурахгүй
    if (renderedCount === 0) {
        POKEMON_CONTAINER.innerHTML = "";
    }

    visiblePokemon
        .slice(renderedCount, revealedCount)
        .forEach(pokemon => {
            renderCard(pokemon);
        });

    renderedCount = Math.min(revealedCount, visiblePokemon.length);
}

// ---------------- НЭГ КАРТ ЗУРАХ ----------------
function renderCard(pokemon) {
    if (!POKEMON_CONTAINER) {
        return;
    }

    const card = document.createElement('div');
    card.classList.add("card", pokemon.types[0].type.name);
    card.dataset.id = pokemon.id;

    const artWork = getArtwork(pokemon);
    const types = getTypesDOM(pokemon);

    card.innerHTML = `
        <div class="card-bg">
            <img class="card-shadow" src="./images/Group 239.svg">
        </div>
        <div class="pokemon-img"><img src="${artWork}" alt="${(pokemon.name).replaceAll("-", " ")}" loading="lazy" /></div>
        <div class="card-content">
            <h3>${(pokemon.name).replaceAll("-", " ")}</h3>
            <h4>#${String(pokemon.id).padStart(3, '0')}</h4>
        </div>
        <div class="types">${types}</div>
    `;

    POKEMON_CONTAINER.appendChild(card);
}

// ============================================================
// 13. MODAL (дэлгэрэнгүй мэдээллийн цонх)
// ============================================================

// ---------------- ЧАДВАРУУД ----------------
function getAbilities(pokemon) {
    return pokemon.abilities.map(
        a => a.ability.name
            .replaceAll("-", " ")
    ).join(", ");
}

// ---------------- ҮНДСЭН ҮЗҮҮЛЭЛТҮҮД (stats) ----------------
function getStats(pokemon) {
    const totalStat = pokemon.stats.reduce((sum, s) => sum + s.base_stat, 0);
    const statsDOM = pokemon.stats.map(s => {
        const statName = s.stat.name.replaceAll("-", " ");
        return `
        <div class="tab-data">
            <div class="stat-name">${statName}</div>
            <div class="stat-value">${s.base_stat}</div>
            <div class="stat-bar">
                <div class="${pokemon.types[0].type.name}" style="max-width: 100%; width:${s.base_stat * 0.39}%; height:6px; border-radius: 8px;"></div>
            </div>
        </div>
    `}).join("");

    const averStat = parseFloat((totalStat / pokemon.stats.length).toFixed(1));
    return `${statsDOM}
        <div class="tab-data">
            <p class="stat-name">Total avg</p>
            <p class="stat-value">${averStat}</p>
            <div class="stat-bar">
                <div class="${pokemon.types[0].type.name}" style="max-width:100%; width:${averStat * 0.39}%; height:6px; border-radius: 8px;"></div>
            </div>
        </div>
    `;
}

// ---------------- НЭРИЙГ CANVAS ДЭЭР ЗУРАХ (gradient текст) ----------------
function drawGradientStrokeText(pokemon) {
    const canvas = document.getElementById("textCanvas");
    const ctx = canvas.getContext("2d");

    const pokemonName = pokemon.name
        .replaceAll("-", " ")
        .split(" ")
        .map(word => word.charAt(0).toUpperCase() + word.slice(1))
        .join(" ");

    // Эхлээд том canvas дээр текстийн жинхэнэ өргөнийг хэмжинэ
    canvas.width = 1600;
    canvas.height = 120;
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.letterSpacing = "2px";
    ctx.font = "800 70px sans-serif";

    const textWidth = ctx.measureText(pokemonName).width;

    // Фонтын хэмжээг 70px-ээр нь үлдээж, canvas-ийн өргөнийг нэрэнд тааруулна
    canvas.width = Math.min(900, Math.ceil(textWidth) + 40);

    // Canvas хэмжээ өөрчлөгдөхөд тохиргоо шинэчлэгддэг тул дахин тохируулна
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.letterSpacing = "2px";
    ctx.font = "800 70px sans-serif";
    ctx.textAlign = "center";
    ctx.textBaseline = "middle";

    const gradient = ctx.createLinearGradient(0, 10, 0, 110);

    gradient.addColorStop(0, "rgba(255, 255, 255, 0.7)");
    gradient.addColorStop(0.5, "rgba(255, 255, 255, 0.3)");
    gradient.addColorStop(0.7, "rgba(255, 255, 255, 0)");
    gradient.addColorStop(1, "rgba(255, 255, 255, 0)");

    ctx.strokeStyle = gradient;
    ctx.lineWidth = 0.3;

    ctx.strokeText(pokemonName, canvas.width / 2, canvas.height / 2);
}

// ---------------- ХУВЬСАХ ШАТЛАЛЫН (evolution) ӨГӨГДӨЛ ЦУГЛУУЛАХ ----------------
// Evolution chain-г шат шатаар нь (stage) цуглуулна.
// stages[0] = үндэс хэлбэр, stages[1] = 1-р шатны хувьслууд, г.м.
async function getEvolutionData(chain) {
    const stages = [];
    let level = [chain];

    while (level.length > 0) {
        const stage = [];

        for (const node of level) {
            const res = await fetch(`https://pokeapi.co/api/v2/pokemon/${node.species.name}`);
            const pokemon = await res.json();

            stage.push({
                name: node.species.name,
                image: pokemon.sprites.other['official-artwork'].front_default || pokemon.sprites.front_default,
                minLevel: node.evolution_details[0]?.min_level ?? null
            });
        }

        stages.push(stage);
        level = level.flatMap(node => node.evolves_to);
    }

    return stages;
}

// ---------------- EVOLUTION-ийг HTML болгож харуулах ----------------
function createEvolutionDOM(stages) {
    if (stages.length === 1 && stages[0].length === 1) {
        const evo = stages[0][0];

        return `
            <div class="evolution-item evolution-single">
                <div class="evol-img">
                    <img src="${evo.image}" alt="${evo.name}">
                </div>
                <p class="evolution-single-text" >This Pokémon doesn't Evolve</p>
            </div>
        `;
    }

    const spriteHTML = evo => `
        <div class="evol-img">
            <img src="${evo.image}" alt="${evo.name}">
        </div>
    `;

    const rowHTML = (fromList, toEvo, minLevel) => `
        <div class="evolution-item">

            ${fromList.map(spriteHTML).join("")}

            <div class="evo-arrow">
                <img src="./images/line-18.svg">

                ${minLevel
            ? `<span>lvl ${minLevel}</span>`
            : ""
        }
            </div>

            ${spriteHTML(toEvo)}

        </div>
    `;

    let evolutionDOM = "";

    // Бүх шатыг нэг мөр дараалал болгож, дараалсан хосуудаар нь харуулна.
    const flat = stages.flat();

    for (let i = 0; i < flat.length - 1; i++) {
        evolutionDOM += rowHTML([flat[i]], flat[i + 1], flat[i + 1].minLevel);
    }

    return evolutionDOM;
}

// ---------------- MODAL - ГОЛ ФУНКЦ ----------------
async function openPokemonModal(id) {
    modalContent.className = "modal-content";
    modalContent.innerHTML = `
        <div class="modal-loader"></div>
    `;

    if (!modal.open) {
        modal.showModal();
    }

    try {
        const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
        const pokemon = await response.json();

        const primaryType = pokemon.types[0].type.name;
        modalContent.classList.add(primaryType);

        const speciesResponse = await fetch(pokemon.species.url);
        const species = await speciesResponse.json();

        const speciesName = species.genera.find(
            item => item.language.name === "en"
        )?.genus.replace(" Pokémon", "");

        const artWork = getArtwork(pokemon);
        const types = getTypesDOM(pokemon);
        const abilities = getAbilities(pokemon);
        const stats = getStats(pokemon);

        // Evolution chain-г ХҮЛЭЭХГҮЙгээр modal-ыг шууд зурна.
        // Evolution tab дотор түр зуурын loader тавина, дараа нь бөглөнө.
        modalContent.innerHTML = `

            <div class="modal-head">
                <canvas id="textCanvas"></canvas>
                <img class="shadow1" src="./images/modal_shadow_1.svg">
                <img class="shadow2" src="./images/modal_shadow_2.svg">
                <div class="modal-img"><img src="${artWork}" alt="${pokemon.name}" /></div>
                <div class="modal-h-text">
                    <h4>#${String(pokemon.id).padStart(3, '0')}</h4>
                    <h3>${(pokemon.name).replaceAll("-", " ")}</h3>
                    <div class="types">${types}</div>
                </div>
            </div>
            
            <div class="modal-main">
                <div class="card-tab">
                    <button class="tab-links" data-tab="about" id="defaultOpen">About</button>
                    <button class="tab-links" data-tab="stats">Base stats</button>
                    <button class="tab-links" data-tab="evolution">Evolution</button>
                </div>

                <div id="about" class="tab-content">
                    <div class="tab-content-list">
                        <div class="tab-data">
                            <p class="about-name">Species</p>
                            <p class="about-value">${speciesName}</p>
                        </div>
                        <div class="tab-data">
                            <p class="about-name">Height</p>
                            <p class="about-value">${pokemon.height * 10}cm</p>
                        </div>
                        <div class="tab-data">
                            <p class="about-name">Weight</p>
                            <p class="about-value">${pokemon.weight / 10}kg</p>
                        </div>
                        <div class="tab-data">
                            <p class="about-name">Abilities</p>
                            <p class="about-value">${abilities}</p>
                        </div>
                    </div>
                </div>
                <div id="stats" class="tab-content">
                    <div class="tab-data-list">
                        ${stats}
                    </div>
                </div>
                <div id="evolution" class="tab-content">
                    <div class="evolution-list">
                        <div class="modal-loader">
                            <img class="spinner" src="./images/loader.svg" alt="">
                        </div>
                    </div>
                </div>
            </div>
        `;

        drawGradientStrokeText(pokemon);

        modalContent.querySelectorAll(".tab-links").forEach(btn => {
            btn.addEventListener("click", evt => openTab(evt));
        });

        const defaultTab = document.getElementById("defaultOpen");
        if (defaultTab) {
            defaultTab.click();
        }

        // Evolution chain-г тусад нь, дараа нь ачаална.
        loadEvolutionTab(species.evolution_chain.url);

    } catch (error) {
        console.error("Modal error:", error);
        modalContent.innerHTML = "<p>Error...</p>";
    }
}

async function loadEvolutionTab(evolutionChainUrl) {
    const evolutionList = document.querySelector("#evolution .evolution-list");
    if (!evolutionList) return;

    try {
        const evolutionResponse = await fetch(evolutionChainUrl);
        const evolution = await evolutionResponse.json();
        const evolutionData = await getEvolutionData(evolution.chain);
        const evolutionDOM = createEvolutionDOM(evolutionData);

        const target = document.querySelector("#evolution .evolution-list");
        if (target) target.innerHTML = evolutionDOM;
    } catch (error) {
            console.error("Modal error:", error);
    }
}

// ---------------- MODAL - ТАВ (tab) СОЛИХ ----------------
function openTab(evt) {
    const targetId = evt.currentTarget.dataset.tab;

    modalContent.querySelectorAll(".tab-content").forEach(tab => {
        tab.style.display = "none";
    });

    modalContent.querySelectorAll(".tab-links").forEach(btn => {
        btn.classList.remove("active");
    });

    document.getElementById(targetId).style.display = "block";
    evt.currentTarget.classList.add("active");
}

// ============================================================
// ШҮҮЛТИЙН MODAL-ыг ҮҮСГЭХ
// ============================================================
function filterDOM() {
    const typeHTML = VALID_TYPES.map(type => `
        <label class="type-item">
            <input type="checkbox" value="${type.toLowerCase()}">
            <span class="checkmark"></span>
            ${type}
        </label>
    `).join("");

    filterModal.innerHTML = `
        <div class="filter-box">
            <div class="filter-header">
                <h3>Filters</h3>
                <i class='bx bx-x filter-close'></i>
            </div>

            <div class="filter-body">
                <h4>Type</h4>
                <div class="filter-types">
                    ${typeHTML}
                </div>
                <h4>Height</h4>
                <div class="filter-height">
                    <div class="filter-small" data-height="small">
                        <img src="./images/small-height.svg" alt="">
                    </div>
                    <div class="filter-medium" data-height="medium">
                        <img src="./images/medium-height.svg" alt="">
                    </div>
                    <div class="filter-large" data-height="large">
                        <img src="./images/large-height.svg" alt="">
                    </div>
                </div>
                <h4>Weight</h4>
                <div class="filter-weight">
                    <div class="filter-small" data-weight="small">
                        <img src="./images/small-weight.svg" alt="">
                    </div>
                    <div class="filter-medium" data-weight="medium">
                        <img src="./images/medium-weight.svg" alt="">
                    </div>
                    <div class="filter-large" data-weight="large">
                        <img src="./images/large-weight.svg" alt="">
                    </div>
                </div>
            </div>
            <div class="filter-footer">
                <div class="btn outline-btn reset-filter">Reset filters</div>
                <div class="btn first-btn apply-filter">Apply filters</div>
            </div>
        </div>
    `;

    filterEvents();
}


// ============================================================
// 14. EVENT LISTENER-ҮҮД
// ============================================================
function setupEventListeners() {
    // Карт дээр дарахад тухайн pokemon-ы modal-ыг нээнэ
    POKEMON_CONTAINER.addEventListener('click', (event) => {

        const clickedCard = event.target.closest('.card');
        if (clickedCard) {
            const pokemonId = clickedCard.dataset.id;
            openPokemonModal(pokemonId);
        }
    });

    closeModalBtn.addEventListener('click', () => {
        modal.close();
    });

    // Modal-ын гадна (backdrop) дарахад хаана
    modal.addEventListener('click', event => {
        const rect = modal.getBoundingClientRect();

        const clickedInside =
            event.clientX >= rect.left &&
            event.clientX <= rect.right &&
            event.clientY >= rect.top &&
            event.clientY <= rect.bottom;

        if (event.target === modal && !clickedInside) {
            modal.close();
        }
    });

    searchBtn.addEventListener("click", searchPokemon);

    searchInput.addEventListener("keydown", event => {
        if (event.key === "Enter") {
            searchPokemon();
        }
    });

    searchInput.addEventListener("focus", () => {
        searchBox.classList.add("active");
    });

    searchInput.addEventListener("blur", () => {
        searchBox.classList.remove("active");
    });

    // Эрэмбийн dropdown нээх/хаах
    sortDropdown.addEventListener("click", () => {
        if (sortMenu.style.display === "block") {
            sortMenu.style.display = "none";
            downDropdown.style.display = "none";
            upDropdown.style.display = "flex";
        } else {
            sortMenu.style.display = "block";
            downDropdown.style.display = "flex";
            upDropdown.style.display = "none";
        }

    });

    sortItems.forEach(item => {
        item.addEventListener("click", () => {
            const value = item.dataset.value;
            const text = item.textContent;

            sortItems.forEach(i => {
                i.classList.remove("active");
            });

            item.classList.add("active");

            selectedSort.textContent = text;
            setSort(value);
        });
    });

    filterBtn.addEventListener("click", () => {
        filterModal.style.display = "flex";
    });

    // Эрэмбийн dropdown-ы гадна дарахад хаана
    document.addEventListener("click", (event) => {
        if (sortMenu.style.display === "block" &&
            !sortDropdown.contains(event.target)) {
            sortMenu.style.display = "none";
            downDropdown.style.display = "none";
            upDropdown.style.display = "flex";
        }
    });

    filterDOM();
}

// ---------------- ШҮҮЛТИЙН MODAL-ЫН EVENT-ҮҮД ----------------
function filterEvents() {

    const closeFilterBtn = filterModal.querySelector(".filter-close");
    const resetBtn = filterModal.querySelector(".reset-filter");
    const applyBtn = filterModal.querySelector(".apply-filter");

    // Close (X) болон Reset товч хоёул шүүлтийг бүрэн цэвэрлэж, цонхыг хаана
    function clearFilterUI() {
        const checkboxes =
            filterModal.querySelectorAll(
                '.filter-types input[type="checkbox"]'
            );

        checkboxes.forEach(checkbox => {
            checkbox.checked = false;
        });

        filterModal
            .querySelectorAll(".filter-height > div, .filter-weight > div")
            .forEach(item => {
                item.classList.remove("active");
            });
    }

    closeFilterBtn.addEventListener("click", () => {
        clearFilterUI();
        filterModal.style.display = "none";
    });

    // Гадна нь (backdrop) дарахад X товчтой адилхан хаана
    filterModal.addEventListener("click", event => {
        if (event.target === filterModal) {
            clearFilterUI();
            filterModal.style.display = "none";
        }
    });

    resetBtn.addEventListener("click", () => {
        clearFilterUI();
        setFilter({ types: [], height: null, weight: null });
    });

    applyBtn.addEventListener("click", () => {

        const types = [
            ...filterModal.querySelectorAll(
                '.filter-types input[type="checkbox"]:checked'
            )
        ].map(input => input.value);

        let selectedHeight =
            filterModal.querySelector(".filter-height .active")?.dataset.height;

        let selectedWeight =
            filterModal.querySelector(".filter-weight .active")?.dataset.weight;

        // Type сонгоогүй бол өндөр/жинг тооцохгүй
        if (types.length === 0) {
            selectedHeight = null;
            selectedWeight = null;
            filterModal
                .querySelectorAll(".filter-height > div, .filter-weight > div")
                .forEach(item => item.classList.remove("active"));
        }

        setFilter({
            types,
            height: selectedHeight || null,
            weight: selectedWeight || null
        });

        filterModal.style.display = "none";
    });

    filterModal
        .querySelectorAll(".filter-height > div")
        .forEach(item => {

            item.addEventListener("click", () => {

                if (item.classList.contains("active")) {
                    item.classList.remove("active");
                } else {
                    filterModal
                        .querySelectorAll(".filter-height > div")
                        .forEach(el => el.classList.remove("active"));
                    item.classList.add("active");
                }
            });

        });

    filterModal
        .querySelectorAll(".filter-weight > div")
        .forEach(item => {

            item.addEventListener("click", () => {

                if (item.classList.contains("active")) {
                    item.classList.remove("active");
                } else {
                    filterModal
                        .querySelectorAll(".filter-weight > div")
                        .forEach(el => el.classList.remove("active"));
                    item.classList.add("active");
                }
            });

        });
}

// ============================================================
// 15. ХАЗАЙХГҮЙ ТАСРАЛТГҮЙ ТАТАЛТ (infinite scroll)
// ============================================================
function setupObserver() {
    const loader = document.querySelector("#loading-trigger");
    if (!loader) {
        return;
    }

    // Хуудасны хамгийн доод хэсэг рүү scroll хийхэд автоматаар цааш татна
    const observer = new IntersectionObserver(
        entries => {
            const canRevealMore = hasMore || revealedCount < visiblePokemon.length;
            if (entries[0].isIntersecting &&
                !isLoading &&
                canRevealMore
            ) {
                loadMore(REVEAL_BATCH_SIZE);
            }
        },
        { rootMargin: "300px" }
    );

    observer.observe(loader);
}

// ============================================================
// 16. ЭХЛҮҮЛЭХ
// ============================================================
async function init() {
    showSkeletons();
    await loadPokemonIndex();
    await loadMore(REVEAL_BATCH_SIZE);

    setupObserver();
    setupEventListeners();
}

init();