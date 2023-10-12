const myNumbers = [20, 30, 45, 66, 88, 22];
let sum = 0;
for(let i = 0; i < myNumbers.length; i++) {
    sum += myNumbers[i];
    console.log(myNumbers[i]);
}

sum = 0;
for (let num of myNumbers) {
    sum += num;
}
console.log(`합: ${sum}`);
sum = 0;
myNumbers.forEach(function(elem, idx) {
    console.log(`index:${idx} - value:${elem}`);
    sum += elem;
});

console.log(`합: ${sum}`);


let fruits = ['Apple', 'Banana', 'Cherry'];
let fruit = document.querySelector('.fruits');
fruit.innerHTML = '';


fruits.forEach(function(elem, idx) {
    let li = document.createElement('li');
    let txt = document.createTextNode(elem);
    li.appendChild(txt);
    fruit.appendChild(li);

    let btn = document.createElement('button');
    btn.innerText = '삭제';
    btn.onclick = function() {
        console.log(btn);
        btn.parentElement.remove();
    }
    li.appendChild(btn);
})


