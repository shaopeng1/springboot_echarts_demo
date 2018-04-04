<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息录入</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>

</head>
<body>
<%-- <shiro:authenticated>用户已经登录显示此内容<br/></shiro:authenticated><br/>
 <shiro:hasRole  name="admin">我是管理员</shiro:hasRole> 
 <shiro:hasRole name="normal">normal角色登录显示此内容<br/></shiro:hasRole><br/>
 <div id="main" style="width:100%; height:400px;"></div> --%>
 <div id="main" style="width:100%; height:400px;"></div>
    <script type="text/javascript">
     $(function(){  
        var url = '${pageContext.request.contextPath}/tubiao';  
       var id = 'main';  
       setChartBar(url);  
    });
    
    function setChartBar(url){
    	var Chart=echarts.init(document.getElementById("main"));  
    	

    	// 显示标题，图例和空的坐标轴
		Chart.setOption({
			title : {
				text : '异步数据加载示例'
			},
			tooltip : {
				trigger:'axis'
			},
			legend : {
			},
			toolbox:{
				show:true,
				feature : {
					dataView : {show:true,reasOnly:false},
					magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
				}
			},
           dataZoom: [
                      {
                          type: 'slider',
                      },
                      {
                          type: 'inside',
                      },
                      {
                          type: 'slider',
                          yAxisIndex: [0],
                          left: '93%',
                      },
                      {
                          type: 'inside',
                          yAxisIndex: [0],
                      }
                  ],
			xAxis : {
				data : []
			},
			yAxis : {
				splitLine : {
					show : false
				},//去除网格线
				name : ''
			},
		});
		Chart.showLoading(); //数据加载完之前先显示一段简单的loading动画
    	 var categories=[];  
    	 var values=[];  
    	 var values2=[];  
    	 $.ajax({
    		    url:url,  
    	        dataType:"json",  
    	        type:'post', 
    	        success:function(json){ 
    	        	categories = json.categories;    
    	            values = json.values;   
    	            values2 = json.values2;   
    	        	var option = {    
    	                    tooltip: {    
    	                        show: true    
    	                    },    
    	                    legend: {    
    	                        data: ['销量']    
    	                    },    
    	                    xAxis: [    
    	                        {    
    	                            type: 'category',    
    	                            data: categories    
    	                        },
    	                    ],
    	                    
    	                    yAxis: [    
    	                        {    
    	                            type: 'value'    
    	                        }    
    	                    ],
    	                    
    	                    series:[{
								name:"张三",
								type:'bar',
								data:values2,
								markPoint : {
					                data : [
					                    {type : 'max', name: '最大值'},
					                    {type : 'min', name: '最小值'}
					                ]
					            },
					            markLine : {
					                data : [
					                    {type : 'average', name: '平均值'}
					                ]
					            }
							},
							{
								name:"李四",
								type:'bar',
								data:values,
								markPoint : {
					                data : [
					                    {type : 'max', name: '最大值'},
					                    {type : 'min', name: '最小值'}
					                ]
					            },
					            markLine : {
					                data : [
					                    {type : 'average', name: '平均值'}
					                ]
					            }
							}],
    	                };
    	        	Chart.hideLoading();  
    	            Chart.setOption(option);
    	        }
    	 })
    }
    </script>
</body>
</html>