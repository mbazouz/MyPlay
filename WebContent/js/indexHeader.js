$('.menu ul').hide(0);
$('.hide').hide(0);

$('.show').click(function(){
  $('.menu').css('width','99%');
  $('.menu ul').slideDown(1000);
  $('.show').hide(500);
  $('.hide').show(500);
});
$('.hide').click(function(){
  $('.menu ul').hide(0);
  $('.hide').hide(500);
  $('.show').show(500);
  $('.menu').css('width','60px');
});