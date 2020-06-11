//Declaração das Variáveis globais
let botaoEnviar = null;
let form = null;
let inputAnalise = null;
let inputBanco = null;
let inputData = null;
let inputDesenvolvimento = null;
let inputEngenharia = null;
let inputEmail = null;
let inputName = null;
let inputRedes = null;
let inputSexoMasculino = null;
let inputSexoFeminino = null;
let inputEstadoCivil = null;
let inputDia = null;
let inputMes = null;
let inputAno = null;

//Função Main
window.addEventListener('load', () => {
  carregaElementos();
  capturaEventos();
  inputName.focus();

  //Função de captura de eventos

  function capturaEventos() {
    botaoEnviar.addEventListener('click', apertouBotaoEnviar);
    form.addEventListener('submit', preventFormSubmit);
  }

  //Função de associação de elementos

  function carregaElementos() {
    botaoEnviar = document.querySelector('#botaoEnviar');
    form = document.querySelector('form');
    inputAnalise = document.querySelector('#inputAnalise');
    inputBanco = document.querySelector('#inputDatabase');
    inputDia = document.querySelector('#inputDay');
    inputMes = document.querySelector('#inputMonth');
    inputAno = document.querySelector('#inputYear');
    inputDesenvolvimento = document.querySelector('#inputDevelopment');
    inputEngenharia = document.querySelector('#inputSoftware');
    inputEmail = document.querySelector('#inputEmail');
    inputName = document.querySelector('#inputName');
    inputRedes = document.querySelector('#inputRedes');
    inputSexoMasculino = document.querySelector('#inputMan');
    inputSexoFeminino = document.querySelector('#inputWoman');
    inputEstadoCivil = document.querySelector('#inputMaritalStatus');
  }
});

//Captura botão submit

const apertouBotaoEnviar = (event) => {
  let user = inputName.value;
  let userEmail = inputEmail.value;
  validaCampos();

  //Função de captura do resultado Estado Civil
  function resCivil(res) {
    if (res === '1') {
      return 'Solteiro';
    }
    if (res === '2') {
      return 'Casado';
    } else {
      return 'Outro(a)';
    }
  }

  //Função de validação de Campos

  function validaCampos() {
    if (user === '' || user.length < 15) {
      window.alert(
        'Você precisa digitar um nome válido com no mínimo 15 caracteres'
      );
      inputName.focus();
    } else if (
      userEmail.length < 10 ||
      userEmail.indexOf('@') == -1 ||
      userEmail.indexOf('.') == -1 ||
      userEmail == '' ||
      userEmail == null
    ) {
      alert('Por favor, indique um e-mail válido.');
      inputEmail.focus();
      return false;
    } else if (inputDia.value < 1 || inputDia.value > 31 || !inputDia.value) {
      alert('Por favor, uma data válida.');
      inputDia.focus();
    } else if (inputMes.value < 1 || inputMes.value > 12 || !inputMes.value) {
      alert('Por favor, uma data válida.');
      inputMes.focus();
    } else if (
      inputAno.value < 1920 ||
      inputAno.value > 2020 ||
      !inputAno.value
    ) {
      alert('Por favor, uma data válida.');
      inputAno.focus();
    } else if (
      resCivil(inputEstadoCivil.value) === 'Solteiro' &&
      inputAno.value > 2005
    ) {
      alert('Solteiros são aceitos apenas maiores de 15 anos');
      inputAno.focus();
    } else {
      window.alert('Dados enviados');
      //alertaMessage();
    }
  }
  function alertaMessage() {
    let message =
      'Nome = ' +
      user +
      '\n' +
      'Email =' +
      userEmail +
      '\n' +
      'Data de Nascimento = ' +
      inputDia.value +
      '/' +
      inputMes.value +
      '/' +
      inputAno.value +
      '\n' +
      'Estado Civil = ' +
      resCivil(inputEstadoCivil.value) +
      ' \n Áreas de Interesse = ';
    alert(message);
  }
};

const preventFormSubmit = (event) => {
  event.preventDefault();
};
