<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <g:set var="entityName" value="${message(code: 'categoriaEntidade.label', default: 'CategoriaEntidade')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>

    %{--<div style="width: 30px; height: 40px; border: solid black 5px"></div>--}%
    <div style="width: 30px; height: 40px; border:black 5px solid"></div>
    %{--<h3 style="text-transform: capitalize; border: 3px black solid">fader azevedo</h3>--}%
    <div class="container-fluid" style="margin-top: 40cm;">
        <form id="formulario">
            <input name="descricao" type="text" required>
            <button class="btn btn-sm btn-warning" type="submit">Save</button>
        </form>
    </div>
        %{--<a href="#create-categoriaEntidade" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>--}%
        %{--<div class="nav" role="navigation">--}%
            %{--<ul>--}%
                %{--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--}%
                %{--<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>--}%
            %{--</ul>--}%
        %{--</div>--}%
        %{--<div id="create-categoriaEntidade" class="content scaffold-create" role="main">--}%
            %{--<h1><g:message code="default.create.label" args="[entityName]" /></h1>--}%
            %{--<g:if test="${flash.message}">--}%
            %{--<div class="message" role="status">${flash.message}</div>--}%
            %{--</g:if>--}%
            %{--<g:hasErrors bean="${this.categoriaEntidade}">--}%
            %{--<ul class="errors" role="alert">--}%
                %{--<g:eachError bean="${this.categoriaEntidade}" var="error">--}%
                %{--<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>--}%
                %{--</g:eachError>--}%
            %{--</ul>--}%
            %{--</g:hasErrors>--}%
            %{--<g:form resource="${this.categoriaEntidade}" method="POST">--}%
                %{--<fieldset class="form">--}%
                    %{--<f:all bean="categoriaEntidade"/>--}%
                %{--</fieldset>--}%
                %{--<fieldset class="buttons">--}%
                    %{--<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />--}%
                %{--</fieldset>--}%
            %{--</g:form>--}%
        %{--</div>--}%

    <asset:javascript src="app.min.js"/>


    <script>
        $(document).ready(function () {
            $("#formulario").submit(function (event) {
                event.preventDefault();
                $.ajax({
                    url: "${g.createLink( controller: 'categoriaEntidade', action:'salvar')}",
                    type: "post",
                    data: $(this).serialize(),
                    success: function (data) {
                        window.location ='/categoriaEntidade/show/'+data.categoria.id;
                        alert('alert sera 1 cena');
                    },
                    error: function () {
                        console.log('Error ao enviar email');
                    }
                });
            });
        })
    </script>
    </body>
</html>
