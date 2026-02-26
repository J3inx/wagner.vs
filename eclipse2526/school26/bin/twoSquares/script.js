const canvas = document.getElementById("gameCanvas");
const ctx = canvas.getContext("2d");
const width = canvas.width;
const height = canvas.height;
const centerX = width / 2;
const centerY = height / 2;
let enemyX = 200;
let enemyY = 300;

let playerX = 1000;
let playerY = 300;

let movementX = 2;
let alive = true;
let color = "blue";
function drawEnemySquare() {
    if(alive){
    ctx.fillStyle = "red";
    ctx.fillRect(enemyX, enemyY, 50, 50);
    }
}

function drawPlayerSquare() {
    ctx.fillStyle = color;
    ctx.fillRect(playerX, playerY, 50, 50);
}

function gameLoop() {
   ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawEnemySquare();
    drawPlayerSquare();
    if(enemyX < playerX + 50 &&
       enemyX + 50 > playerX &&
       enemyY < playerY + 50 &&
       enemyY + 50 > playerY){
        alive = false;
        color = "green";
    }
    update();
    requestAnimationFrame(gameLoop);
}
const keys = {};
window.addEventListener("keydown", function(event) {
    keys[event.key] = true;
});
window.addEventListener("keyup", function(event) {
    keys[event.key] = false;
});
function update(){
    if (keys["ArrowDown"] || keys["s"]) {
        enemyY += 10;
    }else if (keys["ArrowUp"] || keys["w"]) {
        enemyY -= 10;
    }else if (keys["ArrowLeft"] || keys["a"]) {
        enemyX -= 10;
    }else if (keys["ArrowRight"] || keys["d"]) {
        enemyX += 10;
    }
}

gameLoop();