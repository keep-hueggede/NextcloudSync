package AutoDelete;

import Scheduler.TaskService;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.Duration;

public class AutoDelete extends AppCompatActivity {

    protected String path;
    protected Duration duration;
    protected JobScheduler scheduler;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public AutoDelete(String _path, Duration _duration){
        this.path = _path;
        this.duration = _duration;

        this.scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo jobInfo = new JobInfo.Builder(1, new ComponentName(this, TaskService.class))
                .setPeriodic(this.duration.toMillis())
                .setRequiresCharging(false)
                .build();

        this.scheduler.schedule(jobInfo);


    }
}
