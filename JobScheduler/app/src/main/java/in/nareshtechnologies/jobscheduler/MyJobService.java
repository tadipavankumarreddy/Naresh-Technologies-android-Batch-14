package in.nareshtechnologies.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MyJobService extends JobService {

    // Runs on MainThread
    @Override
    public boolean onStartJob(JobParameters params) {
        // This is used for defining the task that you want to do
        Toast.makeText(this, "JOB PERFORMED", Toast.LENGTH_SHORT).show();
        return false; // returns false when the job is finished. true -> when the job is off-loaded
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        // This method helps you terminate the job in between when it is needed
        return false;
    }
}
