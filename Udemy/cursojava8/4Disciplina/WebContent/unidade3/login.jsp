<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Página de Login</title>
</head>
<body>
	<form name="form" action="http://localhost/4Disciplina/unidade3/autenticacao.jsp" method="post">
		CPF: <br />
		<input type="text" name="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" maxlength="14" title="Digite o cpf no formato: XXX.XXX.XXX-XX" required /> <br />
		SENHA: <br />
		<input type="password" name="senha" title="Preencha o campo senha" required /> <br />
		<input type="submit" value="Entrar" />
	</form>
	<p>${mensagem}</p>
</body>
</html>