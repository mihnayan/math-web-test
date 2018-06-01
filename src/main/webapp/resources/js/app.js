'use strict'

function showCalcResult(statusText, resultText) {
    $('p#status-text').html(statusText);
    $('p#result-text').html(resultText);
    $('#calc-result-dialog').modal();
}

function doOperation() {
    let num1 = $('#num-1').val();
    let num2 = $('#num-2').val();
    let url = ['div?num1=', num1, '&num2=', num2].join('');
    $.ajax({
    	url,
    	method: 'post',
    	dataType: 'json'
    }).done(data => {
    	let message;
    	if (data.status === 'ok') {
    		message = [
                'Результат деления ',
                data.num1, ' на ', data.num2, ' равен: '
            ].join('');	
    	} else {
    		message = [
    			'Ошибка обработки сервера при делении ', 
                num1, ' на ', num2, ':'
            ].join('')
    	}
        showCalcResult(message, data.result);
    }).fail((xhr, textStatus) => {
    	console.error(textStatus);
    });
}
