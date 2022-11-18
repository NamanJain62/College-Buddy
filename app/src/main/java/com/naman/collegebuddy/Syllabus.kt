package com.naman.collegebuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Syllabus : AppCompatActivity() {
    private lateinit var adapter3: MyAdapter3
    private lateinit var sylbusrecyclerView: RecyclerView
    private lateinit var sylbusArrayList: ArrayList<syllabusd>

    lateinit var syllabus: Array<String>
    lateinit var desc1: Array<String>
    lateinit var desc2: Array<String>
    lateinit var desc3: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllabus)


        syllabus = arrayOf(
            "Discrete Mathematics",
            "Introductory Topics in Statistics, Probability and calculus",
            "Fundamental of Computer Science",
            "Principles of Electrical Engineering",
            "Physics for Computing Science",
            "Business Communication & Value Science - I",
            "Fundamental of Computer Science Lab",
            "Principles of Electrical Engineering lab",
            "Physics for Computing Science lab",
            "Life Skills & Mentoring(MNG)"
        )

        desc1 = arrayOf(
            "Boolean algebra: Introduction of Boolean algebra, truth table, basic logic gate, basic postulates of Boolean algebra, principle of duality, canonical form, Karnaugh map.\n" +
                    "Abstract algebra: Set, relation, group, ring, field.",
            "Introduction to Statistics: Definition of Statistics, Basic objectives, Applications in various branches of science with examples, Collection of Data: Internal and external data, Primary and secondary Data. Population and sample, Representative sample. Descriptive Statistics: Classification and tabulation of univariate data, graphical representation, Frequency curves. Descriptive measures - central tendency and dispersion. Bivariate data. Summarization, marginal and conditional frequency distribution.",
            "General problem Solving concepts: Algorithm, and Flowchart for problem solving with Sequential Logic Structure, Decisions and Loops.\n" +
                    "Imperative languages: Introduction to imperative language; syntax and constructs of a specific language (ANSI C)\n" +
                    "Types Operator and Expressions with discussion of variable naming and Hungarian Notation: Variable Names, Data Type and Sizes (Little Endian Big Endian), Constants, Declarations, Arithmetic Operators, Relational Operators, Logical Operators, Type Conversion, Increment Decrement Operators, Bitwise Operators, Assignment Operators and Expressions, Precedence and Order of Evaluation, proper variable naming and Hungarian Notation.\n" +
                    "Control Flow with discussion on structured and unstructured programming: Statements and Blocks, If-Else-If, Switch, Loops – while, do, for, break and continue, gotolabels, structured and un- structured programming.",
            "Introduction: Concept of Potential difference, voltage, current, Fundamental linear passive and active elements to their functional current-voltage relation, Terminology and symbols in order to describe electric networks, voltage source and current sources, ideal and practical sources, concept of dependent and independent sources, Kirchhoff-s laws and applications to network solutions using mesh and nodal analysis, Concept of work, power, energy, and conversion of energy.\n" +
                    "DC Circuits: Current-voltage relations of the electric network by mathematical equations to analyze the network (Thevenin’s theorem, Norton's Theorem, Maximum Power Transfer theorem) Simplifications of networks using series-parallel, Star/Delta transformation, and superposition theorem.",
            "Oscillation: Periodic motion-simple harmonic motion-characteristics of simpleharmonic motion-vibration of simple spring mass system. Resonance-definition., dampedharmonic oscillator – heavy, critical and light damping, energy decay in a damped harmonicoscillator, quality factor, forced mechanical and electrical oscillators.\n" +
                    "Interference-principle of superposition-young’s experiment: Theoryof interference fringes-types of interference-Fresnel’s prism-Newton’s rings, Diffraction-Two kinds of diffraction-Difference between interference and diffraction-Fresnel’s half period zone and zone plate-Fraunhofer diffraction at single slit-plane diffraction grating. Temporal and Spatial Coherence.\n" +
                    "Polarization of light: Polarization - Concept of production of polarized beam of light from two SHM acting at right angle; plane, elliptical and circularly polarized light, Brewster’s law, double refraction.",
            "Overview of LOL (include activity on introducing self), Overview of business communication, Self-awareness – identity, body awareness, stress management\n" +
                    "Essential Grammar – Refresher on Parts of Speech\n" +
                    "Tenses: Applications of tenses in Functional Grammar, Common errors, Voices.",
            "Algorithm and flowcharts of small problems like GCD\n" +
                    "Structured code writing with small but tricky codes\n" +
                    "Proper parameter passing",
            "Familiarization of electrical Elements, sources, measuring devices and transducers related to\n" +
                    "electrical circuits\n" +
                    "Determination of resistance temperature coefficient.",
            "Magnetic field along the axis of current carrying coil – Stewart and Gee\n" +
                    "Determination of Hall coefficient of semi-conductor",
            "Not Available"

        )

        desc2 = arrayOf(
            "Combinatorics:Basic counting, balls and bins problems, generating functions, recurrence relations. Proof techniques, principle of mathematical induction, pigeonhole principle.\n" +
                    "Graph Theory: Graphs and digraphs, complement, isomorphism, connectedness and reachability,adjacency matrix, Eulerian paths and circuits in graphs and digraphs, Hamiltonian paths and circuits in graphs and tournaments, trees; Planar graphs, Euler’s formula, dual of a planer graph, independence number and clique number, chromatic number, statement of Four-color theorem.",
            "Probability: Concept of experiments, sample space, event. Definition of Combinatorial Probability. Conditional Probability, Bayes Theorem. Probability distributions:discrete& continuous distributions, Binomial, Poisson and Geometric distributions, Uniform, Exponential, Normal, Chi-square, t, F distributions. Expected values and moments: mathematical expectation and its properties, Moments (including variance) and their properties, interpretation, Moment generating function.",
            "Functions and Program Structure with discussion on standard library: Basics of functions, parameter passing and returning type, C main return as integer, External, Auto, Local, Static, Register Variables, Scope Rules, Block structure, Initialisation, Recursion, Pre-processor,Standard Library Functions and return types.\n" +
                    "Pointers and Arrays: Pointers and address, Pointers and Function Arguments, Pointers and Arrays, Address Arithmetic, character Pointers and Functions, Pointer Arrays, Pointer to Pointer, Multi-dimensional array and Row/column major formats, Initialisation of Pointer Arrays, Command line arguments, Pointer to functions, complicated declarations and how they are evaluated.\n" +
                    "Structures: Basic Structures, Structures and Functions, Array of structures, Pointer of structures, Self-referral structures, Table look up, typedef, unions, Bit-fields",
            "AC Circuits: AC waveform definitions, form factor, peak factor, study of R-L, R-C,RLC series circuit, R-L-C parallel circuit, phasor representation in polar and rectangular form, concept of impedance, admittance, active, reactive, apparent and complex power, power factor, 3 phase Balanced AC Circuits (⅄-Δ&⅄-⅄).\n" +
                    "Electrostatics and Electro-Mechanics: Electrostatic field, electric field strength, concept of permittivity in dielectrics, capacitor composite, dielectric capacitors, capacitors in series and parallel, energy stored in capacitors, charging and discharging of capacitors, Electricity and Magnetism, magnetic field and Faraday's law, self and mutual inductance, Ampere's law, Magnetic circuit, Single phase transformer, principle of operation, EMF equation, voltage ratio, current ratio, KVA rating, efficiency and regulation, Electromechanical energy conversion.",
            "Basic Idea of Electromagnetisms: Continuity equation for current densities, Maxwell’s equation in vacuum and non-conducting medium.\n" +
                    "Quantum Mechanics:Introduction- Planck’s quantum theory- Matter waves, de-Broglie wavelength, Heisenberg’s Uncertainty principle, time independent and time dependent Schrödinger’s wave equation, Physical significance of wave function, Particle in a one dimensional potential box, Heisenberg Picture.\n" +
                    "Crystallography: Basic terms-types of crystal systems, Bravais lattices, miller indices,d spacing,Atomic packing factor for SC, BCC, FCC and HCP structures.\n" +
                    "Semiconductor Physics: Conductor, Semiconductor and Insulator; Basic concept of Band theory.",
            "Communication Skills: Overview of Communication Skills, Barriers of communication, Effective communication, Types of communication- verbal and non – verbal – Role-play based learning, Importance of Questioning, Listening Skills: Law of nature-Importance of listening skills, Difference between listening and hearing, Types of listening,Expressing self, connecting with emotions, visualizing and experiencing purpose\n" +
                    "Verbal communication: Pronunciation, clarity of speech.",
            "Command line Arguments\n" +
                    "Variable parameter\n" +
                    "Pointer to functions\n" +
                    "User defined header\n" +
                    "Make file utility",
            "Verification of Network Theorem (Superposition, Thevenin, Norton, Maximum Power Transfer theorem)\n" +
                    "Simulation of R-L-C series circuits for XL>XC , XL< XC\n" +
                    "Simulation of Time response of RC circuit",
            "Determination of Plank constant\n" +
                    "Determination of wave length of light by Laser diffraction method\n" +
                    "Determination of wave length of light by Newton’s Ring method",
            "Not Available"

        )

        desc3 = arrayOf(
            "Logic: Propositional calculus - propositions and connectives, syntax; Semantics - truthassignments and truth tables, validity and satisfiability, tautology; Adequate set of connectives; Equivalence and normal forms; Compactness and resolution; Formal reducibility - natural deduction system and axiom system; Soundness and completeness.",
            "Calculus: Basic concepts of Differential and integral calculus, application of double and triple integral.",
            "Unix system Interface: File Descriptor, Low level I/O – read and write, open, create, close and unlink, Random access – lseek, Discussions on Listing Directory, Storage allocator.\n" +
                    "Programming Method: Debugging, Macro, User Defined Header, User Defined Library Function, makefile utility.",
            "Measurements and Sensors: Introduction to measuring devices/sensors and transducers (Piezoelectric and thermo-couple) related to electrical signals, Elementary methods for the measurement of electrical quantities in DC and AC systems(Current & Single-phase power). Electrical Wiring and Illumination system: Basic layout of the distribution system, Types of Wiring System &Wiring Accessories, Necessity of earthing, Types of earthing, Safety devices & system.\n" +
                    "For Further Reading - Principle of batteries, types, construction and application, Magnetic material and B-H Curve, Basic concept of indicating and integrating instruments.",
            "Laser and Fiber optics:Einstein’s theory of matter radiation interaction and A and B coefficients; amplification of light by population inversion, different types of lasers: Ruby Laser, CO2 and Neodymium lasers; Properties of laser beams: mono-chromaticity, coherence, directionality and brightness, laser speckles, applications of lasers in engineering.Fiber optics and Applications, Types of optical fibers.\n" +
                    "Thermodynamics: Zeroth law of thermodynamics, first law of thermodynamics, brief discussion on application of 1st law, second law of thermodynamics and concept of Engine, entropy, change in entropy in reversible and irreversible processes.",
            "Email writing: Formal and informal emails, activity,\n" +
                    "Vocabulary Enrichment: Exposure to words from General Service List (GSL) by West, Academic word list (AWL) technical specific terms related to the field of technology, phrases, idioms, significant abbreviations formal business vocabulary – Read Economic Times, Reader’s Digest, National Geographic and take part in a GD, using the words you learnt/liked from the articles. Group discussion using words learnt.\n" +
                    "Written Communication: Summary writing, story writing, Build your CV – start writing your comprehensive CV including every achievement in your life, no format, no page limit.\n" +
                    "Life skill: Stress management, working with rhythm and balance, colours, and teamwork, Understanding Life Skills: Movie based learning – Pursuit of Happiness, critical life skills, Multiple IntelligencesEmbracing diversity, Community service – work with an NGO, Join a trek",
            "Multi file program and user defined libraries\n" +
                    "Interesting substring matching / searching programs\n" +
                    "Parsing related assignments",
            "Verification of relation in between voltage and current in three phase balanced star and delta connected loads.\n" +
                    "Demonstration of measurement of electrical quantities in DC and AC systems.",
            "Determination of laser and optical fiber parameters\n" +
                    "Determination of Stefan’s Constant.",
            "Not Available"

        )

        sylbusrecyclerView = findViewById(R.id.recyclerview3)
        sylbusrecyclerView.layoutManager = LinearLayoutManager(this)
        sylbusrecyclerView.setHasFixedSize(true)

        sylbusArrayList = arrayListOf<syllabusd>()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in syllabus.indices) {
            val syllabus1 = syllabusd(syllabus[i])
            sylbusArrayList.add(syllabus1)
        }

        var adapter = MyAdapter3(sylbusArrayList)
        sylbusrecyclerView.adapter= adapter
        adapter.setOnItemClickListener(object : MyAdapter3.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@HomePage,"You clicked on item no. $position", Toast.LENGTH_SHORT).show()


                val intent = Intent(this@Syllabus,detail_syllabus::class.java)
                intent.putExtra("desc1",desc1[position])
                intent.putExtra("desc2",desc2[position])
                intent.putExtra("desc3",desc3[position])
                startActivity(intent)
            }
        })
    }
}