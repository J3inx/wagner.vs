const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext("2d");
const width = canvas.width;
const height = canvas.height;
const centerX = width / 2;
const centerY = height / 2;
let enemyX = 1175;
let enemyY = 270;
let playerX = 1000;
let playerY = 300;

let movementX = 2;
let alive = true;
let color = "blue";


class rectangle{
    constructor(i, k){
       this.x = i;
       this.y = k;
        this.width = 20;
        this.height = 20;
        this.color = 'green';
        
    }
    draw(context){
        context.beginPath();
        context.fillStyle = this.color;
        context.fillRect(this.x, this.y, 10, 10);
        context.fill();
        context.stroke();
    }
}
class enemy{
    constructor(){
        this.x = enemyX;
        this.y = enemyY;
        this.width = 10;
        this.height = 10;
        this.color = 'red';
    }
    draw(context){
        context.beginPath();
        context.fillStyle = this.color;
        context.fillRect(this.x, this.y, this.width, this.height);
        context.fill();
        context.stroke();
    }
}
const mYenemy = new enemy();
const rectangleArray = [];

for(let k = 10; k < 590; k+=20){
for(let i = 15; i < 1185; i+=20){
   /*  x+= 10;
    if(x > 1200){
        x = 10;
        y += 10;
    }*/
    rectangleArray.push(new rectangle(i, k));
   
}
}
rectangleArray.forEach((rectangle) => rectangle.draw(ctx));

async function gameLoop() {
    console.log("wait");
   await awaitSleep(2000);
    console.log("did");
    ctx.clearRect(0, 0, width, height);
    //console.log("clear");
    let choice = Math.random()
    const paragraph = document.getElementById('movement');
    const paragraph2 = document.getElementById('text');
    
    if(choice < 0.25 && mYenemy.x > 30){
        mYenemy.x -= 20;
        paragraph.textContent = 'Enemy moved left';
    }else if(choice < 0.5 && mYenemy.x < 1155){
        mYenemy.x += 20;
        paragraph.textContent = 'Enemy moved right';
    }else if(choice < 0.75 && mYenemy.y < 570){
        mYenemy.y += 20;
        paragraph.textContent = 'Enemy moved down';
    }else if(choice < 1 && mYenemy.y > 15){
        mYenemy.y -= 20;
        paragraph.textContent = 'Enemy moved up';
    }
    
    rectangleArray.forEach((rectangle) => rectangle.draw(ctx));
    mYenemy.draw(ctx);
     paragraph.style.color = "white";
     paragraph2.style.color = "white";
    await awaitSleep(100);
    paragraph.style.color = "rgb(103, 64, 64)";
    paragraph2.style.color = "rgb(103, 64, 64)";
    requestAnimationFrame(gameLoop);
   
}
function awaitSleep(ms) {
    
    return new Promise(resolve => setTimeout(resolve, ms));
    
}
gameLoop();