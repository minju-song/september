//비동기방식 / fetch();

async function asyncFunc() {
    let memAry = [];
    let promise = await fetch('./MOCK_DATA.json');
    let json = await promise.json();

    memAry = json;

    let list = document.querySelector('#list');
    let ul = document.createElement('ul');

    memAry.reduce((acc,m,idx,ary) => {

        let li = document.createElement('li');
        li.innerHTML = 'id: '+m.id+', name: '+m.first_name;

        if(m.gender == 'Female') li.style.backgroundColor = "pink";
        else if (m.gender == 'Male') li.style.backgroundColor = "skyblue";
        
        if(m.gender == 'Female' || m.gender == 'Male') acc.append(li);
        
        return idx === 4 ? ary.splice(1) : acc;
    }, list.appendChild(ul));








    // memAry.reduce((acc, m, idx, ary) => {
    //     let s = '<li>id : '+m.id+' / first_name: '+m.first_name+'</li>'
    //     if (idx <= 5) {
    //         if (idx == 5) return document.querySelector('div#list').innerHTML = acc+'</ul>'; 
    //         return acc+s;
    //     }
    // }, '<ul>')

    // document.querySelector('div#list').innerHTML = acc+s+'</ul>';
}

asyncFunc();