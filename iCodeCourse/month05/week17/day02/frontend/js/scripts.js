console.log('Promise');

// promise gedeg 
const promise = new Promise(function(resolve, reject){
    resolve("success");
});
console.log(promise);

// NETWORK hvselt ilgeeh

const rejectPromise = new Promise((resolve, reject) => {
    reject("failed");
});

// promise gede8g promise rejection 
console.log(rejectPromise);

const p = new Promise((resolve, reject) => {
    const score = 100;
    if (score > 60) {
        resolve("You win");
    } else {
        reject("You lose");
    }
});

console.log(p);
// chain
p.then((value) => {
    console.log(value);
}).catch((error) => {
    console.error(error);
})

const loadScore = new Promise ((resolve, reject) => {
    const score = 100;
    if (score > 0) {
        resolve(score);
    } else {
        reject("error");
    }
});

loadScore.then((v) => {
    console.log(v)
}).catch(e => {
    console.error(e);
})

const players = ["Bat", "Dorj", "Dulmaa"];

console.log(players);
console.table(players);

function wait(ms) {
    return new Promise(function(resolve, reject) {

        setTimeout (() => {
            resolve("Waited"  + ms + "ms");
        }, ms);
    });
}

console.log(wait(2000));

wait(2000).then(function(msg){
    console.log(msg);
});

// fetchPlayer function name parameter awdag
function fetchPlayer(name) {
    return new Promise((resolve, reject) => {

        setTimeout (() => {
            if(Math.random() > 0.3 ) {
                resolve({name: name, score: 1500});
            } else {
                reject("Server error: could not load " + name);
            }
        }, 1000);
    });
}

fetchPlayer("Bat").then((player) => {
    console.log(`${player.name} has ${player.score} points`);
}).catch((e) => {
    console.error(e);
})