function createTooltip(componente, mensagem){
    $(componente).attr({"rel": "tooltip", 
      "title": mensagem, "data-placement": "bottom"});
    $(componente).tooltip('show');
    setTimeout("$('" + componente + "').tooltip('destroy')", 2000);

  }