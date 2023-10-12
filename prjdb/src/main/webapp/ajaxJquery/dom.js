 		 //element만들때에는 createElement (txt를 만들고싶으면 createTextNode)
        let ul = document.createElement('ul'); //DOM
        let li = document.createElement('li');
        li.setAttribute('class', 'second');
        let txt = document.createTextNode('Apple');
        li.appendChild(txt);
        ul.appendChild(li);

        li = document.createElement('li');
        txt = document.createTextNode('Banana');
        li.setAttribute('class', 'second');
        li.appendChild(txt);
        ul.appendChild(li);

        console.log(ul);

        document.getElementById('clone').appendChild(ul);
        