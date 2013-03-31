function insertRow(table, i, order) {
	var tr = table.insertRow(i);
	if (i % 2 == 1) {
		tr.className = "oddrow";
	}
	var td = tr.insertCell(0);
	td.innerHTML = i;
	td = tr.insertCell(1);
	td.innerHTML = book.name;
	td = tr.insertCell(2);
	td.innerHTML = book.author;
	td = tr.insertCell(3);
	td.innerHTML = book.press;
	td = tr.insertCell(4);
	td.innerHTML = book.count;
	td = tr.insertCell(5);
	td.innerHTML = book.availableCount;
	td = tr.insertCell(6);
	td.innerHTML = book.bookClass;
	td = tr.insertCell(7);
	td.innerHTML = book.price;
	td = tr.insertCell(8);
	td.innerHTML = book.lang;
	td = tr.insertCell(9);
	td.innerHTML = "<a href=\"user/orderBook!openOrderBook?bookId="+book.id+"\">预定图书</a>";
}
function initTable(table){
	for(var i=table.rows.length-1;i>0;i--){
		table.tBodies[0].deleteRow(i);
	}
}
function commonSearch() {
	var query = $("#queryString")[0].value;
	var table=document.getElementById("list");
	initTable(table);
	$.post("searcher!commonSearch", {
		queryString : query
	}, function(list) {
		if (list == null)
			alert("不好意思没有搜索到结果");
		else {
			$.each(list, function(i, book) {
				insertRow(table,i+1,book);
			});
		}
	}, "json");
}