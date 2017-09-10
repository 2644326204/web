<!doctype html>
<html>
<head>
        <meta charset="utf-8">
		<meta name="keywords" content="关键词，关键字">
		<meta name="description" content="描述信息">
		<title>超链接</title>
		<style>
		       *{
			      margin:0 auto;
			   }
		       #canvas{
			       display:block;
				   margin:200px auto;
				   border:3px solid red;
			   }
		</style>
</head>
<body>
         <!-- 画布-->
        <canvas id="canvas" width="500" height="500"></canvas>
		<script>
		/*
		网页的游戏开发:canvas
		企业中：一般页面特效超过5个的时候
		js:基于原型的动态解释性语言
		     1.满足用户需求 点击事件 键盘事件
			 2.操作dom元素(增删改查)   增加修改style属性
			 3.xJax数据交互 json   jeson 正则表达式
			 4.面向对象
			 5.造轮子  vue react angular
			 6.深入底层  学es

		*canvas必须要有的    要有画布   有画笔


		写贪吃蛇的原理：
		改变矩形坐标值
		*/
		var canvas=document.getElementById("canvas");
		var ctx=canvas.getContext("2d"); //创建2D绘图空间、画笔
		var r=[{x:10,y:9},{x:10,y:8}]; //两个对象
		var o=null;
		var stop=false;
		ctx.shadowBlur=20;
		ctx.shadowColor="black";
		co=40;
        //ctx.fillRect(100,100,10,10);
        //贪吃蛇移动
		
		function onframe(){


			//如果有食物  则根据蛇前进的判断是否吃到食物   并且将蛇数组中的最后一个元素换到首部
			if(stop||r[0].x<0||r[0]>=50||r[0].y<0||r[0].y>=50)
			{
			   return;
			}
			if(o){
			    if((co==40&&r[0].x==o.x&&r[1].y+1==o.y)||(co==38&&r[0].x==o.x&&r[1].y-1==o.y)||(co==37&&r[0].y==o.y&&r[1].y-1==o.y)||(co==39&&r[0].y==o.y&&r[1].x+1==o.x))
				{
				     r.unshift(o);
					 o=null;
				}
			}
		r.unshift(r.pop());  //把两个对象调换位置
		//r[0].x=r[1].x;
		switch(co)
			{
			case 37:
				{
				   r[0].y=r[1].y;
				   r[0].x=r[1].x-1;
				   break;
				}
			case 38:
				{
				     r[0].x=r[1].x;
                     r[0].y=r[1].y-1;
					 break;
				}
			case 39:
				{
				   r[0].y=r[1].y;
				   r[0].x=r[1].x+1;
				   break;
				}
			case 40:
				{
					 r[0].x=r[1].x;
                     r[0].y=r[1].y+1;
					 break;
				}
			}
		



        ctx.clearRect(0,0,500,500);
		//绘制贪吃蛇
		for(var i=0,len=r.length;i<len;i++)
		{
        ctx.fillRect(r[i].x*10,r[i].y*10,10,10);
		}
		if(o==null)
			{
			   o={y:Math.random()*50 >>>0,x:Math.random()*50 >>>0}
			}
	    if(o){
		     ctx.fillRect(o.x*10,o.y*10,10,10);
		}
		     if(r[0].x<0||r[0]>=50||r[0].y<0||r[0].y>=50)
			{
			    alert("Game over!\n");
				alert("此次游戏玩了"+(r.length-2)+"分")
			}
		}
		setInterval(onframe,500);

		//加入键盘事件，用键盘来控制蛇的前进方向
        //每一个键盘对应一个值
		document.onkeyup=function(event){
            if(event.keyCode>=37 && event.keyCode<=40 &&Math.abs(event.keyCode-co)!=2)
			{
			       co=event.keyCode;
				   console.log(co);
			}
		    if(event.keyCode==32)
			{
			    stop=!stop;
			}
			//console.log(a);
		}
		</script>
</body>
</html>
