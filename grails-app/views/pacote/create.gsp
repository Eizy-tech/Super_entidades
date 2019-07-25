<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="admin" />
    <g:set var="entityName" value="${message(code: 'pacote.label', default: 'Pacote')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>

<div class="container-fluid">
    <form id="formulario">
        <input name="descricao" type="text" placeholder="Descricao" required>
        <input name="estado" type="text" placeholder="estado" required>
        <input name="preco" type="text" placeholder="preco" required>
        <button class="btn btn-sm btn-warning" type="submit">Save</button>
    </form>
</div>

<asset:javascript src="app.min.js"/>


<script>
    $(document).ready(function () {
        $("#formulario").submit(function (event) {
            event.preventDefault();
            $.ajax({
                url: "${g.createLink( controller: 'pacote', action:'salvar')}",
                type: "post",
                data: $(this).serialize(),
                success: function (data) {
                    //window.location ='/categoriaEntidade/show/'+data.categoria.id;
                    alert(data.msg);
                    // console.log(data.pacote);
                },
                error: function (data) {
                    alert(data.msg);
                    // console.log(data.msg);
                }
            });
        });
    })
</script>
</body>
</html>
