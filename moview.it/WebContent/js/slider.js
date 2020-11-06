$(function() {
    function pad(num, size) {
      var s = num+"";
      while (s.length < size) s = "0" + s;
      return s;
    }
    var formatSecs = function(totalsecs) {
      var hour = parseInt( totalsecs / 3600, 10) % 24;
      var min = parseInt( totalsecs / 60, 10) % 60;
      var secs = totalsecs % 60;

      return pad(hour,2)+":"+pad(min,2)+":"+pad(secs,2);
    };

    $( "#slider-range" ).slider({
      range: true,
      min: 0,
      max: 86400,
      values: [ 7200, 72000 ],
      slide: function( event, ui ) {
        var min = ui.values[0]; 
        var max = ui.values[1]; 

        $( "#amount" ).val( formatSecs(min)+" - "+formatSecs(max) );
      }
    });

    $( "#amount" ).val( formatSecs($( "#slider-range" ).slider( "values", 0 ))+" - "+formatSecs($( "#slider-range" ).slider( "values", 1 )) );
    
  });