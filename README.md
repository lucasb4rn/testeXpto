<h1> FERRAMENTAS UTILIZADAS </h1>
<p> IDE ECLIPSE </p>
<p> TOMCAT VERSÃO 8.5 </p>
<p> HIBERNATE </p>
<p> C3PO - POOL </p>
<p> SPRING FRAMEWORK </p>
<p> SPRING DATA </p>
<p> MYSQL 5.7 - Legacy Mode </p>

A class JPAConfigurator contém os dados para utilização do banco de dados;

<h1> Context da aplicação está definido cmo /Xpto </h1>

<h2> Provável URL: http://localhost/Xpto </h2>

<h1> API RECURSOS </h1>

<p> GET /arquivo </p>
<p> GET /cidadeCapitaisOrdenadosPorNome </p>
<p> GET /estadoMaiorEMenor </p>
<p>GET /quantidadeCidadePorEstado</p>
<p>GET /cidade/{idIbge}</p>
<p>GET /retornaCidadePorEstado/{estado}</p>
<p>POST /adicionarCidade</p>
<p>DELETE /deletaCidade/{idIbge}</p>
<p>GET /cidade/{coluna}/{conteudo}</p>
<p>GET /quantidadeColuna/{coluna}</p>
<p>GET /quantidadeTotalRegistros</p>
<p>GET /maiorDistanciaEntreDuasCidades</p>


Exemplo para teste Method: Post - Body /adicionarCidade 
Json: 
{"idIbge":8888888,
"estado":{"id":110,"nome":"ES"},
"name":"CidadeName","capital":"SIM",
"longitude":-48.4878256875,
"latitude":-1.459845,
"nomeSecundario":"",
"regiao": 
{"id": 2041,
"microRegion": "MicroRegionName",
"mesoRegion": "MesoRegionName"
}
}




