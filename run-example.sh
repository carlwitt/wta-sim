# tiny example
# java -cp target/wta-sim-0.1.jar science.atlarge.wta.simulator.WTASim \
#    -i /Users/macbookdata/Downloads/workload-trace-archive/workflows/askalon-new_ee10_parquet/ \
#    -o simulation_results/ \
#    --target-utilization 0.7 \
#    --task-placement-policy best_fit

# larger example
java -cp target/wta-sim-0.1.jar science.atlarge.wta.simulator.WTASim \
   -i /Users/macbookdata/Downloads/workload-trace-archive/workflows/spec_trace-1_parquet/ \
   -o simulation_results/ \
   --target-utilization 0.7 \
   --task-placement-policy best_fit
