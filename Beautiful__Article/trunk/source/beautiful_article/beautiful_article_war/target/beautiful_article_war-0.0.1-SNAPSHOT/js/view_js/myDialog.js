/**
 * Created by fkk on 2016/12/9.
 */
$(function(){
    $("#dialog").dialog({
        autoOpen: false,
        show: {
            effect: "blind",
            duration: 1000
        },
        hide: {
            effect: "explode",
            duration: 1000
        }
    });
    $("#opener").click(function () {
        $("#dialog").dialog("open");
    });
});
function prompt_dialog(data) {
    $("#error-dialog-error-label").text(data);
    $("#dialog").dialog("open");
    setTimeout(function() {
            $("#dialog").dialog("close");
            $("#error-dialog-error-label").text("");
        },
        2000)
}