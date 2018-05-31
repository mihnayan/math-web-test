'use strict'

function calc(num1, num2) {
    return new Promise((resolve, reject) => {
        let calcResult = new Number(num1/num2);
        if ($.isNumeric(calcResult)) {
            resolve(calcResult);
        } else {
            reject('Не возможно преобразовать результат в число!');
        }
    })
}

function showCalcResult(statusText, resultText) {
    $('p#status-text').html(statusText);
    $('p#result-text').html(resultText);
    $('#calc-result-dialog').modal();
}

function doOperation() {
    let num1 = $('#num-1').val();
    let num2 = $('#num-2').val();
    calc(num1, num2)
        .then(result => {
            let message = [
                'Результат деления ',
                num1, ' на ', num2,
                ' равен: ', result
            ].join('');
            showCalcResult(
                ['Результат деления ', num1, ' на ', num2, ' равен: '].join(''),
                result
            );
        })
        .catch(e => {
            showCalcResult(
                ['Ошибка обработки сервера при делении ', 
                    num1, ' на ', num2, ':'
                ].join(''), e);
      });
}
