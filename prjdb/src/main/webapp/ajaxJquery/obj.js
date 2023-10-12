let name = "Hong"; //string
let age = 20; //number
let obj = {
	name,
	age,
	phone: '010-1111-1111',
	showInfo: function() {
        return this.name+", "+this.age;
    }
}
console.log(obj['name']);
console.log(obj['age']);
console.log(obj['phone']);
console.log(obj.showInfo());
obj.hobbies = ['reading', 'eating', 'sleeping'];
console.log(obj.hobbies[0]);

for (let prop in obj) {
    console.log(`속성: ${prop},  값: ${obj[prop]}`);
}

let yourHobbies = ['운동하기', '영화보기', '자전거타기'];

function makeHobbies(hobbies=[]) {
    for(let prop of hobbies) {
        let li = document.createElement('li');
        let txt = document.createTextNode(prop);
        li.appendChild(txt);
        document.getElementById('myHobby').appendChild(li);
    
    }
}

makeHobbies(yourHobbies);


