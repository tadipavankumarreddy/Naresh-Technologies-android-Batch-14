package in.nareshtechnologies.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // To cancel or schedule a job, we need JobScheduler object
    JobScheduler scheduler;
    // to set up the conditions, we need JobInfo object
    JobInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        info = new JobInfo.Builder(123, new ComponentName(this, MyJobService.class.getName()))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .build();

    }

    public void scheduleJob(View view) {
        scheduler.schedule(info);
    }

    // Define the job in JobService class

}