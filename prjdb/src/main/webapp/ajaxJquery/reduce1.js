//reduce1.js
console.log("gg");
let memberAry = [];
fetch('./MOCK_DATA.json')
.then(resolve => resolve.json())
.then(result => {
    memberAry = result;
    let str = "";
    memberAry.forEach((m,idx) => {
        if(idx == 0) str+= '<ul>';
        if(idx < 5) str += '<li> id : '+m.id+', first_name : '+m.first_name+'</li>'
        if(idx == (memberAry.length-1)) str += '</ul>';
    });

    str2 = "";
    let str3 = memberAry.reduce((acc, m, idx, ary) => {
        str2 = acc+'<li> id : '+m.id+', first_name : '+m.first_name+'</li>';
        if(idx == ary.length-1) return str2+'</ul>'
        else {
            return str2
        }
    }, '<ul>');
    str2 += '</ul>'
    // console.log(str3);
    document.querySelector('#list').innerHTML = str3;

    let ary5 = memberAry.filter((m,idx, ary) => {
        // console.log(m, idx, ary);
        return idx < 5;
    })

    let scores = [3, 2, 6, 9, 5];

    let avg = scores.reduce((acc, scr, idx, ary) => {                    
        if (idx == ary.length-1) return (acc+scr)/ary.length;
        return acc+scr;
    }, 0)

    console.log(avg);
});