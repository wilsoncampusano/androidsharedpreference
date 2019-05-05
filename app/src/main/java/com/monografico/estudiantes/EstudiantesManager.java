package com.monografico.estudiantes;

import java.util.ArrayList;
import java.util.List;

public class EstudiantesManager {

    public final static EstudiantesManager e = new EstudiantesManager();

    public List<Estudiante> estudiantesList(){
        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante(1L, "Luis Ariel", "Mejia Beltre", "http://virtual.uasd.edu.do/user/pix.php/50394/f1.jpg"));
        estudiantes.add(new Estudiante(2L, "Juand", "Mejia", "https://www.morpht.com/sites/morpht/files/styles/landscape/public/dalibor-matura_1.jpg?itok=gxCAhwAV"));
        estudiantes.add(new Estudiante(3L, " Ariel", "Mejia Beltre", "https://bittaxer.com/wp-content/uploads/2018/03/danielle-profile-bittaxer.jpg"));
        estudiantes.add(new Estudiante(4L, "Carlos", "Mejia Beltre", "https://daks2k3a4ib2z.cloudfront.net/55d62f32fa59c51977889877/561d4d3b8cf0398714ac71b5_MM-092714_Avatar.jpg"));
        estudiantes.add(new Estudiante(5L, "Johnathan", "Mejia Beltre", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4Dyl_4V_fW1rrZQ-mPPQaTGvIwnGT3mzmTQ-pWpPpQ6FiwffJNQ"));
        estudiantes.add(new Estudiante(6L, "El pardo", "Mejia Beltre", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2it5gWw0Qri4SmsZO6E6Y_P4BveunzwmjoVrrHzOHOrbF-MKQVg"));
        estudiantes.add(new Estudiante(7L, "Luis", "Mejia", "https://www.howtogeek.com/wp-content/uploads/2018/08/profile-photo-highest-res.jpg"));

        return estudiantes;
    }
}
