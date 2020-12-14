<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>



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
	        text: '오늘의 하이브피자 총 메뉴 클릭 수 차트'
	    },

	    subtitle: {
	        text: ''
	    },

	    yAxis: {
	        title: {
	            text: '피자 클릭 수'
	        }
	    },

	    xAxis: {
	        accessibility: {
	            rangeDescription: 'Range: 1 to 10000'
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
		url:'getdata1.mc',
		success:function(data){
			display(data);
		},
		error:function(){}
	});
};

$(document).ready(function(){
	getData();
});
</script>


<h1>하이브피자</h1>
<div id="container">

</div>





