import matplotlib.pyplot as plt
import numpy as np
import pandas as pd


df = pd.read_csv("data.csv")
fig, ax = plt.subplots(1, 4,figsize=(40, 5))
df.groupby(['<DATE>']).boxplot(column="<OPEN>,<HIGH>,<LOW>,<CLOSE>".split(","), ax=ax)
plt.show()