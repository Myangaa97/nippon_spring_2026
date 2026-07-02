const books = [
    { id: 1, title: "Clean Code", author: "Robert Martin", pages: 464 },
    { id: 2, title: "Effective Java", author: "Joshua Bloch", pages: 416 },
    { id: 3, title: "Java Basics", author: "Saraa", pages: 220 },
    { id: 4, title: "Spring Up", author: "Saraa", pages: 310 }
];

console.log("------------- Бүх номыг хэвлэх -------------");
for (const book of books) {
    console.log(book);
}

console.log("------------- Зөвхөн гарчгийг хэвлэх -------------");
for (const book of books) {
    console.log(book.title);
}

console.log("------------- Sara: зохиогчийн номыг олох -------------");
for (const book of books) {
    if (book.author === "Saraa") {
        console.log(book);
    }
}

console.log("------------- Хамгийн олон хуудастай ном -------------");
let longestBook = books[0];
for (const book of books) {
    if (book.pages > longestBook.pages) {
        longestBook = book;
    }
}

console.log(longestBook);

console.log("------------- Нийт хуудасны тоо -------------");
let totalPages = 0;
for (const book of books) {
    totalPages += book.pages;
}

console.log(totalPages);

console.log("------------- Function: зохиогчийн номыг олох -------------");
function getBooksByAuthor(author) {
    const result = [];

    for (const book of books) {
        if (book.author === author) {
            result.push(book);
        }
    }

    return result;
}

console.log(getBooksByAuthor("Saraa"));

console.log("------------- Function: хамгийн урт номыг буцаах -------------");
function getLongestBook() {
    let longestBook = books[0];

    for (const book of books) {
        if (book.pages > longestBook.pages) {
            longestBook = book;
        }
    }

    return longestBook;
}

console.log(getLongestBook());

console.log("------------- Function: нийт хуудасны тоог буцаах -------------");
function getTotalPages() {
    let total = 0;

    for (const book of books) {
        total += book.pages;
    }

    return total;
}

console.log(getTotalPages());

console.log("------------- Function: хамгийн урт ном title-ийг буцаах -------------");
function getLongestBook() {
    let longestBook = books[0];

    for (const book of books) {
        if (book.pages > longestBook.pages) {
            longestBook = book;
        }
    }

    return longestBook.title;
}

console.log(getLongestBook());

console.log("------------- Function: single object-оос formatted string гаргах -------------");
function bookCard(book) {
    return `${book.title} - ${book.author} (${book.pages} pages)`;
}

console.log(bookCard(books[0]));

console.log("------------- Function: номын хуудас minPages-ээс их эсэх -------------");
function isLongBook(book, minPages) {
	return book.pages > minPages;
}

console.log(isLongBook(books[2], 300));
console.log(isLongBook(books[0], 300));