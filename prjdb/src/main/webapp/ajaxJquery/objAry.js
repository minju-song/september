const mem1 = {
    name: "홍길동",
    age: 20,
    phone: "010-1111"
}

const mem2 = {
    name: "김길동",
    age: 23,
    phone: "010-2222"
}

const mem3 = {
    name: "박길동",
    age: 26,
    phone: "010-3333"
}

const members = [mem1, mem2, mem3];

let target = document.querySelector('#memberList>tbody');

members.forEach(addMember);

document.querySelector('#memberList>tbody button').onclick = function(e) {
    e.target.parentElement.parentElement.remove();
}



function addMember(member = {}) {
        let tr = document.createElement('tr');
    
        for(let prop in member) {
            let td = document.createElement('td');
            td.innerText = member[prop];
            tr.appendChild(td);
        }
        let td = document.createElement('td');
        let btn = document.createElement('button');
        btn.innerText = "삭제";
        td.appendChild(btn);
        tr.appendChild(td);
    
        btn.addEventListener('click', function(e) {
            this.parentElement.parentElement.remove();
        });
    
        document.querySelectorAll('#memberList>tbody>tr').onmouseover = function(e) {
            this.setAttribute('style', 'background:pink');
        }
        
        target.appendChild(tr);
    }


// document.querySelector('.add').addEventListener('click', function(e) {
//     let tr = document.createElement('tr');

//     let td = document.createElement('td');
//     td.innerText = document.querySelector('input[name=name]').value;
//     tr.appendChild(td);
//     td = document.createElement('td');
//     td.innerText = document.querySelector('input[name=age]').value;
//     tr.appendChild(td);
//     td = document.createElement('td');
//     td.innerText = document.querySelector('input[name=phone]').value;
//     tr.appendChild(td);

//     td = document.createElement('td');
//     let btn = document.createElement('button');
//     btn.innerText = "삭제";
//     td.appendChild(btn);
//     tr.appendChild(td);

//     target.appendChild(tr);
// })


document.querySelector('.add').onclick = function(e) {
    console.log("버튼");

    let name = document.querySelector('input[name=name]').value
    let age = document.querySelector('input[name=age]').value
    let phone = document.querySelector('input[name=phone]').value

    const member = {
        name, age, phone
    }
    
    addMember(member);
}

document.querySelectorAll('#memberList>tbody>tr').forEach(function(tr) {
    tr.addEventListener('mouseover', function(e) {
        tr.setAttribute('style','background:pink');
    })

    tr.addEventListener('mouseout', function(e) {
        tr.setAttribute('style','null');
    })
})
//this가 객체 내에서 쓰이면 객체를 가리키고 
//이벤트리스너 안이면 그 이벤트를 받는 대상