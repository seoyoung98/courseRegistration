/**
 * 
 */
window.onload = call;
function call() {
	document.querySelector("#search_pro").onclick = search_pro;
	document.querySelector("#search_major").onclick = search_major;
	document.querySelector("#search_sub").onclick = search_sub;
	document.querySelector("#subInsert").onclick = function() {
		location.href = "subInsert.do";
	};
}

function search_pro() {
	var proname = document.querySelector("#professor_name").value;
	alert(proname);
	var nodelist = document.querySelectorAll("#subtr");

	nodelist.forEach(function(row) {
		var td = row.querySelector("td:nth-child(6)");
		if (td && td.textContent === proname) {
			row.style.display = "table-row";
		} else {
			row.style.display = "none";
		}
	});
}

function search_major() {
	var proname = document.querySelector("#major").value;
	alert(proname);
	var nodelist = document.querySelectorAll("#subtr");
	nodelist.forEach(function(row) {
		var td = row.querySelector("td:nth-child(3)");
		if (td && td.textContent === proname) {
			row.style.display = "table-row";
		} else {
			row.style.display = "none";
		}
	});
}

function search_sub() {
	var proname = document.querySelector("#sub_name").value;
	alert(proname);
	var nodelist = document.querySelectorAll("#subtr");
	nodelist.forEach(function(row) {
		var td = row.querySelector("td:nth-child(4)");
		if (td && td.textContent === proname) {
			row.style.display = "table-row";
		} else {
			row.style.display = "none";
		}
	});
}


