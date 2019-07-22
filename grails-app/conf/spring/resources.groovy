import super_entidades.UtilizadorPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    utilizadorPasswordEncoderListener(UtilizadorPasswordEncoderListener, ref('hibernateDatastore'))
}
