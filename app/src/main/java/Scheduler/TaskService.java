package Scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class TaskService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        return onStartJob(jobParameters, new ICallback() {
            @Override
            public void callback() {

            }
        });
    }

    public boolean onStartJob(JobParameters jobParameters, ICallback callback) {
        callback.callback();
        return false;
    }


    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
