public List<SysUsuario> getListUsuarioRevisor(String idtem) {
    if (idtem.isEmpty() != true) {
      String idlastperiodo = daoperiodo.obtenerUltimoRegistroPeriodo();
      if (idlastperiodo.isEmpty() != true) {
        Periodo enperiodoActual = daoperiodo.obtenerPeriodoPorIdActivo(Integer.parseInt(idlastperiodo), true);
        this.listUsuarioRevisor = daousuario.obtenerListadoUsuarioPorPerfilAsignado(TIPO_LABEL_PERFIL_DOCENTE, idtem, TIPO_ID_ASIGNACION_REVISOR + "", ESTADO_ID_TEMA_REVISA_TERMINADO + "", enperiodoActual.getIdPrd());
      }
    }
    return listUsuarioRevisor;
  }