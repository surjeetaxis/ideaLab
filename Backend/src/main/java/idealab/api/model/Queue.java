package idealab.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "queue")
public class Queue extends RecordTimestamp {
    
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @OneToOne()
    @JoinColumn(name="fk_print_job_id", referencedColumnName = "id", nullable = false, unique = true)
    private PrintJob printJob;
    
    @Column(name = "rank", nullable = false)
    private Long rank;

    public Queue() {}

    public Queue(PrintJob printJob, Long rank) {
        this.printJob = printJob;
        this.rank = rank;
    }

    //getters and setters
    public Long getRank() {
        return rank;
    }

    public void setEmailHash(Long rank) {
        this.rank = rank;
    }

}

