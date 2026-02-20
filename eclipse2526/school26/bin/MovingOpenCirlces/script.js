const canvas = document.getElementById("gameCanvas");
const ctx = canvas.getContext("2d");
const width = canvas.width;
const height = canvas.height;
const centerX = width / 2;
const centerY = height / 2;
let rotationOffset = 0;
let circleY = 300;
let circleX = 600;
let accelX = 0.09;
let xSpeed = 10;
let ySpeed = 0;
function drawRotatingCircles() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.beginPath();
    ctx.arc(centerX, centerY, 200, 0, Math.PI * 2);
    ctx.fillStyle = '#08e5a1'
    ctx.fill()
    ctx.closePath();
    rotationOffset += 0.01;
    ctx.beginPath();
    const StartingAngle = 0 + rotationOffset;
    const endAngle = (Math.PI * 1.8) + rotationOffset;
    ctx.arc(centerX, centerY, 200, StartingAngle, endAngle);
    ctx.strokeStyle = '#40e014';
    ctx.lineWidth = 8;
    ctx.lineCap = 'round';
    ctx.stroke();
    ctx.closePath();
    requestAnimationFrame(drawRotatingCircles);
}
function drawBouncingCircles() {
    //console.log("test");
    
    const gravity = 0;
    circleX += xSpeed;
    circleY += ySpeed;
    ySpeed += accelX;
   ctx.beginPath();
   ctx.arc(circleX, circleY, 10, 0, Math.PI * 2);
   let ballRadius = 10;
   ctx.fillStyle = '#ff0000';
   ctx.fill();
   ctx.closePath();
    // Collision detection for left/right walls
    if (Math.sqrt(Math.pow(circleX - centerX, 2) + Math.pow(circleY - centerY, 2)) > 200) {
 
    let nx = centerX - circleX;
    let ny = centerY - circleY;
    let dist = Math.sqrt(nx * nx + ny * ny);
    nx /= dist;
    ny /= dist; 

    let dotProduct = (xSpeed * nx) + (ySpeed * ny);


    xSpeed = xSpeed - 2 * dotProduct * nx;
    ySpeed = ySpeed - 2 * dotProduct * ny;
    

    circleX = centerX - nx * 199;
    circleY = centerY - ny * 199;
}
    requestAnimationFrame(drawBouncingCircles);
    
}
drawRotatingCircles();
drawBouncingCircles();