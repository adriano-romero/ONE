// import {Cliente} from "./Cliente.js"
// import {ContaCorrente} from "./Conta/ContaCorrente.js"
// import { ContaPoupanca } from "./Conta/ContaPoupanca.js";
// import {ContaSalario} from './Conta/ContaSalario.js';
// import {Conta} from "./Conta/Conta.js";

import { Diretor } from "./Funcionarios/Diretor.js"
import { Gerente } from "./Funcionarios/Gerente.js";
import { SistemaAutenticacao } from "./SistemaAutenticacao.js";

// const cliente1 = new Cliente("Ricardo", 11122233309);

// const contaCorrenteRicardo = new ContaCorrente(cliente1, 1001);
// contaCorrenteRicardo.depositar(500);
// contaCorrenteRicardo.sacar(100);

// console.log(contaCorrenteRicardo);

// const contaPoupanca = new ContaPoupanca(0,cliente1, 1001);
// contaPoupanca.depositar(50);
// console.log(contaPoupanca);

const diretor =  new Diretor("Rodrigo", 10000, 12345678900);
diretor.cadastrarSenha("123456")
const gerente =  new Gerente("Ricardo",  5000, 12378945601);
gerente.cadastrarSenha("123");

const estaLogado = SistemaAutenticacao.login(gerente, "123");



