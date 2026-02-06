const canvas = document.getElementById("gameCanvas");
const ctx = canvas.getContext("2d");
const width = canvas.width;
const height = canvas.height;
const centerX = width / 2;
const centerY = height / 2;
let rotationOffset = 0;

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

drawRotatingCircles();