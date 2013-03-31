var orders = [];
function insertRow(table, i, order) {
	var tr = table.insertRow(i);
	if (i % 2 == 1) {
		tr.className = "oddrow";
	}
	var td = tr.insertCell(0);
	td.innerHTML = i;
	td = tr.insertCell(1);
	td.innerHTML = order.name;
	td = tr.insertCell(2);
	td.innerHTML = order.author;
	td = tr.insertCell(3);
	td.innerHTML = order.bookClass;
	td = tr.insertCell(4);
	td.innerHTML = order.orderDate;
	td = tr.insertCell(5);
	td.innerHTML = order.deadline;
	td = tr.insertCell(6);
	td.innerHTML = order.price;
	td = tr.insertCell(7);
	td.innerHTML = order.press;
	td = tr.insertCell(8);
	td.innerHTML = "<a href=\"admin/borrow!openOrderBook?orderId=" + order.id
			+ "\">借阅</a>";
}
function initTable(table) {
	for ( var i = table.rows.length - 1; i > 0; i--) {
		table.tBodies[0].deleteRow(i);
	}
}

function borrowAll() {
	if (orders.length == 0) {
		alert("请先查询订单");
	} else {
		 alert(orders);
		$.post("admin/borrow!ajaxForBorrowBooks", $.param({
			orders : orders
		}, true), function(data) {
			if (data) {
				alert("借书成功");
			} else {
				alert("借书失败");
			}
		}, "json");
	}
}
function getOrders() {
	var userId = $("#borrower")[0].value;
	var parttern = /\d+/;
	if (parttern.test(userId)) {
		$.post("admin/borrow!ajaxForOrderList", {
			userId : userId
		}, function(data) {
			if (data != null) {
				var table = document.getElementById("orders");
				orders = new Array(data.length);
				$.each(data, function(i, order) {
					orders[i] = order.id;
					insertRow(table, i + 1, order);
				});
			} else {
				alert("这个人没有订单");
			}
		}, "json");
	} else {
		alert("只接受数字");
	}
}
