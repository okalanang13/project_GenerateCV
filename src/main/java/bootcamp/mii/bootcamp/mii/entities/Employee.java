/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone")
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address")
    , @NamedQuery(name = "Employee.findByIsDelete", query = "SELECT e FROM Employee e WHERE e.isDelete = :isDelete")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private Character gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Column(name = "isDelete")
    private Character isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<Achievement> achievementList;
    @OneToMany(mappedBy = "idManager", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @JoinColumn(name = "id_manager", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee idManager;
    @JoinColumn(name = "id_region", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Religion idRegion;
    @JoinColumn(name = "id_village", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Village idVillage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<Experience> experienceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<EmployeeEducation> employeeEducationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<EmployeeTraining> employeeTrainingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<EmployeeLanguage> employeeLanguageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<WorkAssignment> workAssignmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<EmployeeCertification> employeeCertificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<Organization> organizationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<EmployeeSkill> employeeSkillList;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String firstName, String lastName, Character gender, String email, String phone, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Character getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Character isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<Achievement> getAchievementList() {
        return achievementList;
    }

    public void setAchievementList(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getIdManager() {
        return idManager;
    }

    public void setIdManager(Employee idManager) {
        this.idManager = idManager;
    }

    public Religion getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Religion idRegion) {
        this.idRegion = idRegion;
    }

    public Village getIdVillage() {
        return idVillage;
    }

    public void setIdVillage(Village idVillage) {
        this.idVillage = idVillage;
    }

    @XmlTransient
    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    @XmlTransient
    public List<EmployeeEducation> getEmployeeEducationList() {
        return employeeEducationList;
    }

    public void setEmployeeEducationList(List<EmployeeEducation> employeeEducationList) {
        this.employeeEducationList = employeeEducationList;
    }

    @XmlTransient
    public List<EmployeeTraining> getEmployeeTrainingList() {
        return employeeTrainingList;
    }

    public void setEmployeeTrainingList(List<EmployeeTraining> employeeTrainingList) {
        this.employeeTrainingList = employeeTrainingList;
    }

    @XmlTransient
    public List<EmployeeLanguage> getEmployeeLanguageList() {
        return employeeLanguageList;
    }

    public void setEmployeeLanguageList(List<EmployeeLanguage> employeeLanguageList) {
        this.employeeLanguageList = employeeLanguageList;
    }

    @XmlTransient
    public List<WorkAssignment> getWorkAssignmentList() {
        return workAssignmentList;
    }

    public void setWorkAssignmentList(List<WorkAssignment> workAssignmentList) {
        this.workAssignmentList = workAssignmentList;
    }

    @XmlTransient
    public List<EmployeeCertification> getEmployeeCertificationList() {
        return employeeCertificationList;
    }

    public void setEmployeeCertificationList(List<EmployeeCertification> employeeCertificationList) {
        this.employeeCertificationList = employeeCertificationList;
    }

    @XmlTransient
    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    @XmlTransient
    public List<EmployeeSkill> getEmployeeSkillList() {
        return employeeSkillList;
    }

    public void setEmployeeSkillList(List<EmployeeSkill> employeeSkillList) {
        this.employeeSkillList = employeeSkillList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.mii.bootcamp.mii.entities.Employee[ id=" + id + " ]";
    }
    
}
