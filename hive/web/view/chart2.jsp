<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
#container{
	width:800px;
	height:500px;
	border:2px solid red;
}
</style>

<script>
function display(data){
	Highcharts.chart('container', {

	    title: {
	        text: '최근 10일 간 서울시 확진자'
	    },

	    subtitle: {
	        text: '서울시 제공'
	    },

	    yAxis: {
	        title: {
	            text: '서울시 확진자 수'
	        }
	    },

	    xAxis: {
	        accessibility: {
	            rangeDescription: 'Range: 1 to 10'
	        }
	    },

	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },

	    plotOptions: {
	        series: {
	            label: {
	                connectorAllowed: false
	            },
	            pointStart: 1
	        }
	    },

	    series: data,

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    }

	});
};

function getData(){
	$.ajax({
		url:'getdata2.mc',
		success:function(data){
			//alert(data);
			display(data);
		},
		error:function(){}
	});
	
};



$(document).ready(function(){
	getData();
});



</script>

<h1>Chart2</h1>
<div id="container">

</div>