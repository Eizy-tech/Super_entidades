<!doctype html>
<html>
<head>
    <meta name="layout" content="website"/>
    <title>Super Entidades Title</title>
</head>
<body>
    <div id="content" role="main">
        <section class="row colset-2-its">
            <div id="controllers" role="navigation">
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>
</body>
</html>




