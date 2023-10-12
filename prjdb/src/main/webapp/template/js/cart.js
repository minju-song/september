// cart.js 의 시작부분.
console.log('cart.js');

// Intl 객체를 사용하여 포맷 지정.
function number_format(amount) {
	return new Intl.NumberFormat('ko-KR', {
		style: 'currency',
		currency: 'KRW'
	}).format(amount);
}

// prototype에 정의해서 메소드 추가: 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
	if (this == 0) return 0;
	let regex = /(^[+-]?\d+)(\d{3})/;
	let nstr = (this + '');
	while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
	return nstr;
};

// 1,000,000 => 1000000
//console.log('1,000,000'.replace(/,/g, ''));

let basket = {
	cartCount: 0,
	cartTotal: 0,
	delCheckedItem: function () {
	// 선택된 상품을 삭제....금액을 재계산.
		let checks = [];
		checks = document.querySelectorAll("input[type='checkbox']:checked");

		checks.forEach((item, idx) => {
			console.log(item.parentElement.parentElement.parentElement);
			item.parentElement.parentElement.parentElement.remove();


		})
		basket.reCalc();

	},
	delAllItem: function () {
	// 장바구니 비우기 하면 실행되도록..
		let all = [];
		all = document.querySelectorAll("div.row.data");
		all.forEach((item, idx) => {
			item.remove();
		})
		basket.reCalc();

	},
	reCalc: function () {
	// 금액을 재계산.
	 let prices = [];
	 prices = document.getElementsByName('itemPrice');
	let sumPrice = 0;
	 prices.forEach((item,idx) => {
		sumPrice += Number(item.getAttribute('value'));
	 })

	 basket.cartTotal = sumPrice;
	

	 let counts = [];
	 counts = document.querySelectorAll('.p_num');
	 let sumCounts = 0;
	 counts.forEach((item,idx) => {
		sumCounts += Number(item.getAttribute("value"));
		// console.log(Number(item.getAttribute("value")));
	 })

	 basket.cartCount = sumCounts;

	},
	updateUI: function () {
		location.reload();
	},
	changePNum: function (e, str) {
	// 수량변경.
		let price =Number(e.parentElement.parentElement.parentElement.childNodes[1].childNodes[1].value);
		
		let val = Number(e.parentElement.childNodes[1].value);
		if (str == 'plus') {
			e.parentElement.childNodes[1].setAttribute("value", val+1);
		}
		else if (str == 'minus') {
			if (e.parentElement.childNodes[1].value>1) {
				e.parentElement.childNodes[1].setAttribute("value", val-1);
			}
		}
		
		let currentVal =Number(e.parentElement.childNodes[1].getAttribute('value'));

		let currentNum = price*currentVal;
		e.parentElement.parentElement.parentElement.childNodes[5].setAttribute("value", currentNum );
		e.parentElement.parentElement.parentElement.childNodes[5].innerText = currentNum.formatNumber()+'원';
		basket.reCalc();
	},
	delItem: function (e) {
	// 삭제버튼 클릭시.
		console.log(e.parentElement.parentElement.parentElement);
		e.parentElement.parentElement.parentElement.remove();

		basket.reCalc();

	},
	cartList: function () {
	// 상품목록 출력...아래에 있는 상품정보를 활용해서 수량만큼 출력이 되도록.
		cartItems.forEach((item, idx) => {
			let template = document.querySelector('div.row.data').cloneNode(true);
			
			//이미지 설정
			template.childNodes[1].childNodes[3].querySelector('img').src = './img/'+item.image;
			
			//이름 설정
			template.childNodes[1].childNodes[5].querySelector('span').innerText = item.productNm;
			
			//금액 설정
			template.childNodes[3].childNodes[1].lastChild.replaceWith(item.price.formatNumber()+"원");
			template.childNodes[3].childNodes[1].querySelector('input').value = item.price;
			
			//수량설정
			template.querySelector('#p_num1.p_num').setAttribute("value",item.qty);
			template.querySelector('#p_num1.p_num').setAttribute("id","p_num"+(idx+2));

			//품목별 현재 가격 계산
			let sump = item.price*item.qty;
			template.childNodes[3].childNodes[5].setAttribute('value', sump);
			template.childNodes[3].childNodes[5].setAttribute('name', 'itemPrice');
			template.childNodes[3].childNodes[5].innerText = sump.formatNumber()+"원";

			//붙히기
			document.querySelector('div.row.data').after(template);
		})

	}
};

var cartItems = [{
		no: 1,
		productNm: '아이인형',
		qty: 2,
		price: 12000,
		image: 'doll.png'
	},
	{
		no: 2,
		productNm: '곰인형',
		qty: 1,
		price: 22000,
		image: 'teddy-bear.png'
	},
	{
		no: 3,
		productNm: '공룡인형',
		qty: 1,
		price: 13600,
		image: 'dino.png'
	}
]

basket.cartList();
basket.reCalc();

// 1. db를 연결해서 사용하려면 아래의 내용으로 작업을 하면 됨.
//fetch('cartSelectList')
//	.then(resolve => resolve.json())
//	.then(result => {
//		//console.log(result);
//		basket.cartList();
//	})
//	.catch(err => console.log(err))

