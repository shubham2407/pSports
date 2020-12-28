var i=0;
var imagefiles=['rbags4.jpg','rbags5.jpg','rbags7.jpg','rbags9.jpg','rbags12.jpg'];
window.setInterval(startSlider,1500);

function startSlider()
{
	document.getElementById("topimg").src="images/slider/"+imagefiles[i];
	i++;
	if(i>4)
	{
		i=0;
	}
}

