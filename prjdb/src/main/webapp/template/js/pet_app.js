
var pets = [];

App = {
	adoptedAry: [], //adopted.json/입양버튼 클릭시 id저장
	init: function() {
	// pets.json 파일의 정보를 읽어서 애완견의 정보를 활용해서 페이지 생성.
	 
		fetch("./json/pets.json")
		.then((res) => {
		  return res.json()
		})
		.then((obj) => {
		  obj.forEach((item,idx)=>{

			let template = document.querySelector('div#temp').cloneNode(true);
			template.querySelector('.panel-title').innerText = item.name;
			template.querySelector('img.img-rounded.img-center').src = item.picture;
			template.querySelector('span.pet-breed').innerText = item.breed;
			template.querySelector('span.pet-age').innerText = item.age;
			template.querySelector('span.pet-location').innerText = item.location;
			template.querySelector('button.btn-adopt').setAttribute("data-id", item.id);
			document.querySelector('#petsRow').appendChild(template);
		  });
		  App.initContract();
		})

	}, // end of init;

	initContract: function() {
	// initMarkData 호출.
	// bindEvents 호출.
		App.initMarkData();
		App.bindEvents();

	
	}, // end of initContract;

	bindEvents: function(e) {
		// 입양버튼에 이벤트 등록. ->markAdopted 활용
		let btnevt = document.querySelectorAll('.btn-adopt');
		btnevt.forEach((item,idx)=>{
			item.addEventListener('click',function(){
				App.markAdopted(this);
			});
		})

	},

	initMarkData: function() {
		// adopted.json 정보를 활용해서 입양처리하기.
		fetch("./json/adopted.json")
		.then((res) => {
		  return res.json()
		})
		.then((obj) => {
			App.adoptedAry = obj;
			// console.log(App.adoptedAry);
			App.handleAdopt();
		})
	},

	markAdopted: function(e) {
		// 입양처리. adoptedAry에 추가.
		//console.log(e.getAttribute('data-id'));
		App.adoptedAry.push(Number(e.getAttribute('data-id')));
		//console.log(App.adoptedAry);
		App.handleAdopt();
	}, // end of markAdopted;

	handleAdopt: function(event) {
		// 사용자화면에서 입양버튼 클릭 시 처리.버튼 비활성화
		//console.log(App.adoptedAry);
	
		App.adoptedAry.forEach((item,idx)=>{
			//console.log(item);
			//$('.btn-adopt[data-id=1]')
			let complete=$('.btn-adopt[data-id='+item+']');

			complete.attr('disabled','true');
			complete.html("입양완료");
		})
		
		

	} // end of handleAdopt;

}; // end of App;



$(function() {
	App.init();
});
