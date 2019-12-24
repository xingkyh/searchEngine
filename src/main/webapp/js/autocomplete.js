function enterToSearch() {
  var input = document.getElementsByClassName("search-button");
  input.addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode == 13) {
      document.getElementsByClassName("search-button").click();
    }
  });
}

function getData(url) {
  var jsonData = "";
  $.ajax({
    type: "get",
    url: url,
    datatype: "json",
    async: false,
    error: function() {
      console.error("Load recommand data failed!");
    },
    success: function(data) {
      jsonData = data;
    }
  });
  return jsonData;
}

$(function () {
  var recommandData;

  $(".search-input").autocomplete({
    source: recommandData
  });

  $(".search-input").keyup(
    function(event){
      recommandData=JSON.parse(getData("test.txt"));
    }
  )
});