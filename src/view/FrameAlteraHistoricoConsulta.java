package view;

import java.awt.event.ActionListener;

public class FrameAlteraHistoricoConsulta extends FrameAtendeConsulta {
    public FrameAlteraHistoricoConsulta(ActionListener listener) {
       super(listener);
       setJButtonFinalizar("Atualizar");
       setJButtonOff();
    }   
}