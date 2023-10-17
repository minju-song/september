export default {
	template : `
		<div style="display: flex;">
			<div style="flex: 3;">
			
				<form id="frm"> 
					<div class="form-group">
						<label for="id">도서코드</label>
						<input type="text" v-model="id">
					</div>           
					<br>
					<div class="form-group">
						<label for="name">도서명</label>
						<input type="text" v-model="name">
					</div>
					<br>
					<div class="form-group">
						<label for="writer">저자</label>
						<input type="text" v-model="writer">
					</div>
					<br>
					<div class="form-group">
						<label for="company">출판사</label>
						<input type="text" v-model="company">
					</div>
					<br>
					<div class="form-group">
						<label for="price">금액</label>
						<input type="number" v-model="price">
					</div>
				</form>
			</div>
			<div style="flex: 1; text-align:center; line-height:80px;">
				<button v-on:click="insert">저장</button>
				<br>
				<button onclick="deleteCk()">선택삭제</button>
		 	</div>
		</div>
	`,
	data : function() {
		return {
			id : '',
			name : '',
			writer : '',
			company : '',
			price : 0
		}
	},
	methods : {
		insert() {
			this.$emit('add', this.id, this.name, this.writer, this.company, this.price);
			[this.id, this.name, this.writer, this.company, this.price] = ['','','','','',0];
		}
	}
}