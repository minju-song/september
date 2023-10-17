export default {
	template : `
		<div>
			<table>
				<thead>
					<tr>
						<th>도서코드</th>
						<th>도서명</th>
						<th>저자</th>
						<th>출판사</th>
						<th>가격</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="b in books">
						<td>{{b.bookId}}</td>
						<td>{{b.bookName}}</td>
						<td>{{b.bookWriter}}</td>
						<td>{{b.bookCompany}}</td>
						<td>{{b.bookPrice}}</td>
						<td><button v-on:click="remove(b.bookId)">삭제</button></td>
					</tr>
				</tbody>
			</table>
			<button v-on:click="addPage">등록하기</button>
		</div>
	`,
	props : ['books'],
	methods : {
		addPage() {
			this.$emit('addpage');
		},
		remove(id) {
			this.$emit('remove',id);
		}
	}
}