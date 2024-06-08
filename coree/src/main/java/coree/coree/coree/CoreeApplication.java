package coree.coree.coree;

import coree.coree.coree.Data.Enum.Filiere;
import coree.coree.coree.Data.entities.*;
import coree.coree.coree.Data.entities.Module;
import coree.coree.coree.Data.repositories.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CoreeApplication implements CommandLineRunner {
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	ProfesseurClasseModulesRepository professeurClasseModulesRepository;
	@Autowired
	AnneeScolaireRepository anneeScolaireRepository;
	@Autowired
	ProfesseurRepository professeurRepository;
	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	CoursRepository coursRepository;
	@Autowired
	SessionCoursRepository sessionCoursRepository;
	@Autowired
	InscriptionRepository inscriptionRepository;
	@Autowired
	EtudiantsRepository etudiantsRepository;
	@Autowired
	EmargementRepository emargementRepository;
	public static void main(String[] args) {
		

		SpringApplication.run(CoreeApplication.class, args);



	}

	@Override
	public void run(String... args) throws Exception {
		/*List<Module> mod=  professeurClasseModulesRepository.findProfesseurClasseModulesByProfesseurAndClasse(professeurRepository.findProfesseurById(5L),classeRepository.findClasseById(1L)).getModules();
		System.out.println(mod);*/
		//System.out.println(coursRepository.findAll());
		/*SessionCours sessionCours=sessionCoursRepository.findById(1);
		Cours cours=sessionCours.getCours();
		List<Classe> classes=cours.getClasses();
		List<Semestre> semestres=cours.getSemestres();
		//System.out.println(semestres);
		List<Etudiant> etudiants=new ArrayList<>();
		classes.forEach(element -> {
			element.getInscriptions().forEach(ins->{
				if (ins.getAnneeScolaire().getActive()){
					etudiants.add(ins.getEtudiant());
				}
			});
		});
		System.out.println(etudiants);*/
	}
}
