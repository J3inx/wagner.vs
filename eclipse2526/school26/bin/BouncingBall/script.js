const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext("2d");
//two objects
let b1 = {
    x: 200,
    y: -50,
    vx: 4,
    vy: 2,
    radius: 30,
    color: '#fac6d9',
}
let b2 = {
    x: Math.random() * 100+500,
    y: Math.random() * -50,
    vx: -4,
    vy: 2,
    radius: 30,
    color: '#d6741f',
}
function update(){
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    const balls = [b1, b2];
    balls.forEach(b=> {
        b.vy+=0.2;
        b.x += b.vx;
        b.y += b.vy;

        ctx.beginPath();
        ctx.arc(b.x, b.y, b.radius, 0, Math.PI * 2);
        ctx.fillStyle = b.color;
        ctx.fill();
        ctx.closePath();
    });
    requestAnimationFrame(update);
}
update();